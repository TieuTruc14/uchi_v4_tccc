package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.persistence.ManualDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLConnection;
import java.util.List;


/**
 * Created by Admin on 26/10/2017.
 */
public class ManualDownloadFileAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ManualDownloadFileAction.class);
    private int id;
    private int count;

    public String execute() throws Exception{
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");

        try {

            Manual itemDB = beanManualDao.getManual(id);
            String[] file_path = null;
            String[] file_name = null;

            if (itemDB != null) {
                if (!StringUtils.isBlank(itemDB.getFilePath())) {
                    file_path = itemDB.getFilePath().split(",");
                }
                if (!StringUtils.isBlank(itemDB.getFileName())) {
                    file_name = itemDB.getFileName().split(",");
                }
            }
            if (file_path.length > 0) {
                File file = new File(file_path[count-1]);
                if (!file.exists()) {
                    String errorMessage = "Sorry. The file you are looking for does not exist";
                    OutputStream outputStream = getResponse().getOutputStream();
                    outputStream.write(errorMessage.getBytes());
                    outputStream.close();
                    return INPUT;
                }
                String mimeType = URLConnection.guessContentTypeFromName(file.getName());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }
                getResponse().setContentType(mimeType);
                getResponse().setHeader("Content-Disposition", String.format("inline; filename=\"" + file_name[count-1] + "\""));
                getResponse().setContentLength((int) file.length());
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                FileCopyUtils.copy(inputStream, getResponse().getOutputStream());
                inputStream.close();
            } else {
                String errorMessage = "Sorry. The file you are looking for does not exist";
                OutputStream outputStream = getResponse().getOutputStream();
                outputStream.write(errorMessage.getBytes());
                outputStream.close();
                return INPUT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NONE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
