package com.osp.web.admin.config;

import com.osp.common.util.Constants;
import com.osp.common.util.EditString;
import com.osp.common.util.XmlHandler;
import com.osp.common.utils.FileUtil;
import com.osp.common.web.AbstractAction;
import com.osp.model.ConfigBackupDatabaseForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Admin on 30/10/2017.
 */
public class ConfigInitEditAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ConfigViewAction.class);
    private ConfigBackupDatabaseForm cfBackup = new ConfigBackupDatabaseForm() ;
    private String message;

    public String execute() throws Exception{
        try{

            if (FileUtil.checkFileExits("backup-config.xml",getText("system.backup.folder"))) {
                cfBackup.setPathBackUp(XmlHandler.getValueNode("Folder"));
                if (XmlHandler.getValueNode("StatusBackup").equals("true")) {
                    cfBackup.setCheckBackup(true);
                } else {
                    cfBackup.setCheckBackup(false);
                }
                cfBackup.setBackupTime(XmlHandler.getValueNode("TimeBackup"));
                cfBackup.setEmail(XmlHandler.getValueNode("Emails"));
                List<Boolean> listDatebackup = null;
                if (org.apache.commons.lang3.StringUtils.isBlank(XmlHandler.getValueNode("DatesBackup"))) {
                    cfBackup.setMon(false);
                    cfBackup.setTue(false);
                    cfBackup.setWed(false);
                    cfBackup.setThu(false);
                    cfBackup.setFri(false);
                    cfBackup.setSat(false);
                    cfBackup.setSun(false);
                } else {
                    listDatebackup = EditString.parseListDateBackup1(XmlHandler.getValueNode("DatesBackup"));
                    cfBackup.setMon(listDatebackup.get(0));
                    cfBackup.setTue(listDatebackup.get(1));
                    cfBackup.setWed(listDatebackup.get(2));
                    cfBackup.setThu(listDatebackup.get(3));
                    cfBackup.setFri(listDatebackup.get(4));
                    cfBackup.setSat(listDatebackup.get(5));
                    cfBackup.setSun(listDatebackup.get(6));
                }
            } else {
                if (cfBackup == null) cfBackup = new ConfigBackupDatabaseForm();
                /*session.removeAttribute(ConfigBackupDatabaseForm.SESSON_KEY);*/
                cfBackup.setPathBackUp(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER));
                cfBackup.setCheckBackup(Boolean.valueOf(getText(Constants.CHECK_BACKUP_DATABASE)));
                cfBackup.setBackupTime(getText(Constants.CONFIG_TIME_BACKUP));
                cfBackup.setEmail(getText(Constants.CONFIG_EMAIL_BACKUP));
                List<Boolean> listDatebackup = null;
                listDatebackup = EditString.parseListDateBackup1(getText(Constants.CONFIG_DATE_BACKUP));
                cfBackup.setMon(listDatebackup.get(0));
                cfBackup.setTue(listDatebackup.get(1));
                cfBackup.setWed(listDatebackup.get(2));
                cfBackup.setThu(listDatebackup.get(3));
                cfBackup.setFri(listDatebackup.get(4));
                cfBackup.setSat(listDatebackup.get(5));
                cfBackup.setSun(listDatebackup.get(6));
            }

        }catch (Exception e){
            logger.error("ConfigViewAction"+e.getMessage());
        }
        return SUCCESS;
    }

    public ConfigBackupDatabaseForm getCfBackup() {
        return cfBackup;
    }

    public void setCfBackup(ConfigBackupDatabaseForm cfBackup) {
        this.cfBackup = cfBackup;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
