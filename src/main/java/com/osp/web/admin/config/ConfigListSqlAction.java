package com.osp.web.admin.config;

import com.osp.common.util.Constants;
import com.osp.common.util.EditString;
import com.osp.common.web.AbstractAction;
import com.osp.model.BackupInfo;
import com.osp.model.BackupList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


/**
 * Created by Admin on 31/10/2017.
 */
public class ConfigListSqlAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ConfigListSqlAction.class);
    private BackupList backupList;


    public String execute() throws Exception{
        String key = "";
        if(backupList!= null){
            key = backupList.getFilename();
        }else {
            backupList = new BackupList();
        }

        File folder = new File(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER));
        folder = folder.getAbsoluteFile();

        if (!folder.exists()) {
            if(folder.mkdirs()){

                System.out.println(" Tạo thành công foder");
            }else {
                return ERROR;
            }
        }
        File[] listFiles = folder.listFiles();
        ArrayList<BackupInfo> listBackup = new ArrayList<BackupInfo>();
        BackupInfo info = null;
        SimpleDateFormat splFomat = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        for (File file : listFiles) {
            if (!EditString.isNull(key)) {
                if (file.getName().indexOf(key) > -1) {
                    info = new BackupInfo();
                    if (!file.getName().equals("backup.bat") && !file.getName().equals("backupnow.bat") && !file.getName().equals("restore.bat") && !file.isDirectory()) {
                        info.setFileName(file.getName());
                        info.setDateFile(splFomat.format(file.lastModified()));
                        listBackup.add(info);
                    }
                }
            } else {
                info = new BackupInfo();
                if (!file.getName().equals("backup.bat") && !file.getName().equals("backupnow.bat") && !file.getName().equals("restore.bat") && !file.isDirectory()) {
                    info.setFileName(file.getName());
                    info.setDateFile(splFomat.format(file.lastModified()));
                    listBackup.add(info);
                }
            }
        }
        backupList.setList(listBackup);
        /*Collections.sort(listBackup, new Comparator<BackupInfo>() {

            public int compare(BackupInfo o1, BackupInfo o2) {
                SimpleDateFormat splFomat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
                try {
                    Date date1 = splFomat1.parse(o1.getDateFile());
                    Date date2 = splFomat1.parse(o2.getDateFile());
                    return date1.compareTo(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        Collections.reverse(listBackup);*/

        return SUCCESS;
    }

    public BackupList getBackupList() {
        return backupList;
    }

    public void setBackupList(BackupList backupList) {
        this.backupList = backupList;
    }
}
