package com.osp.web.category.manual;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.persistence.ManualDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24/10/2017.
 */
public class ManualRemoveFileUrlAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ManualRemoveFileUrlAction.class);
    private int count;
    private int id;
    private String ok;


    public String execute() throws Exception{
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");
        Manual manualDB = beanManualDao.getManual(id);
        List<String> fileName = new ArrayList<String>();
        List<String> filePath = new ArrayList<>();
        String manualFileName = "";
        String manualFilePath = "";

        try{
            File file = new File(manualDB.getFilePath().split(",")[count-1]);
            if(file.exists()){
                file.delete();
            }
            for(int i=0;i<manualDB.getFileName().split(",").length;i++) {
                if (i != count - 1) {
                    fileName.add(manualDB.getFileName().split(",")[i]);
                }
            }
            for(int i=0;i<manualDB.getFilePath().split(",").length;i++) {
                if (i != count - 1) {
                    filePath.add(manualDB.getFilePath().split(",")[i]);
                }
            }
            for(int i=0;i<fileName.size();i++){
                manualFileName += fileName.get(i)+",";
            }
            for(int i=0;i<filePath.size();i++){
                manualFilePath += filePath.get(i)+",";
            }
            if(!StringUtils.isBlank(manualFilePath) && !StringUtils.isBlank(manualFileName)){
                manualFilePath= manualFilePath.substring(0,manualFilePath.length()-1);
                manualFileName= manualFileName.substring(0,manualFileName.length()-1);
            }
            manualDB.setFilePath(manualFilePath);
            manualDB.setFileName(manualFileName);
            beanManualDao.edit(manualDB);
                setOk("ok");
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
