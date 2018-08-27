package com.osp.web.category.manual;

import com.osp.common.utils.FileUtil;
import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.model.User;
import com.osp.persistence.ManualDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 17/10/2017.
 */
public class ManualEditSaveAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ManualEditSaveAction.class);

    private Manual item;
    private String message;
    private List<File> fileUpload = new ArrayList<File>();
    private List<String> fileUploadContentType = new ArrayList<String>();
    private List<String> fileUploadFileName = new ArrayList<String>();

    public String execute() throws Exception {
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");
        try{
            Manual itemDB = beanManualDao.getManual(item.getId());
            if(itemDB == null) return INPUT;

            changeValueManual(itemDB,item);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            itemDB.setDateUpdated(new Date());
            itemDB.setUserUpdated(user);

            beanManualDao.edit(itemDB);
            message = " cập nhật thành công";

        }catch (Exception e){
            logger.error("ManualEditSaveAction"+e.getMessage());
        }
        return SUCCESS;
    }
    public void changeValueManual(Manual itemDB, Manual item){

        itemDB.setTitle(item.getTitle());
        itemDB.setContent(item.getContent());
        String fileName= itemDB.getFileName()+",";
        String filePath = itemDB.getFilePath()+",";
        try{
            File fileNew = FileUtil.createNewFile(getText("system_manual_data_folder"),"MANUAL_");
            if(fileUpload != null){

                int j = fileUpload.size();
                for(int i = 0;i<j;i++){
                    FileOutputStream outputStream = new FileOutputStream(fileNew);
                    FileInputStream inputStream = new FileInputStream(fileUpload.get(i));
                    int c;
                    while ((c=inputStream.read()) !=-1){
                        outputStream.write(c);
                    }
                    filePath += fileNew.getAbsolutePath()+",";

                }
                if(fileUploadFileName != null){
                    int k = fileUploadFileName.size();
                    for(int i=0;i<k;i++){
                        fileName += fileUploadFileName.get(i)+",";
                    }
                }

            }
            fileName=(fileName.substring(0,fileName.length()-1));
            filePath= (filePath.substring(0,filePath.length()-1));
            itemDB.setFileName(fileName);
            itemDB.setFilePath(filePath);
        } catch (Exception e){
            e.printStackTrace();
        }


    }


    public List<File> getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(List<File> fileUpload) {
        this.fileUpload = fileUpload;
    }

    public List<String> getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(List<String> fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public List<String> getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(List<String> fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public Manual getItem() {
        return item;
    }

    public void setItem(Manual item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void validate(){

        if(StringUtils.isBlank(item.getTitle())){
            addFieldError("item.title", "Không bỏ trống trường này!");
        }


    }
}
