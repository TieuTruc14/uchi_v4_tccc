package com.osp.web.admin.config;

import com.osp.common.util.EditString;
import com.osp.common.util.XmlHandler;
import com.osp.common.web.AbstractAction;
import com.osp.model.ConfigBackupDatabaseForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 28/10/2017.
 */
public class ConfigEditSaveAction extends AbstractAction {
     private Logger logger = LogManager.getLogger(ConfigEditSaveAction.class);
     private String message;
    private ConfigBackupDatabaseForm cfBackup;

     public String execute() throws Exception{
         if (cfBackup.getPathBackUp() != null && cfBackup.getPathBackUp().length() > 0) {
             if (cfBackup.getPathBackUp().trim().indexOf(" ") > 0) {

                 message=getText("err.cfg.backup.filepath");
                 return INPUT;
             }
         } else {

             message= getText("err.cfg.backup.not.filepath");
             return INPUT;
         }

         String dateBackUp = String.valueOf(cfBackup.isMon()) + " "
                 + String.valueOf(cfBackup.isTue()) + " "
                 + String.valueOf(cfBackup.isWed()) + " "
                 + String.valueOf(cfBackup.isThu()) + " "
                 + String.valueOf(cfBackup.isFri()) + " "
                 + String.valueOf(cfBackup.isSat()) + " "
                 + String.valueOf(cfBackup.isSun());
         //SystemProperties.saveProperties(Constants.CONFIG_DATE_BACKUP, dateBackUp);
         XmlHandler.checkExitsAndWriteFile("<?xml version = \"1.0\" encoding = \"UTF-8\" standalone = \"yes\"?>\n" +
                 "<data>\n" +
                 "    <Folder>" + EditString.convertToFilePath(cfBackup.getPathBackUp().replaceAll("\\\\", "/")) + "</Folder>\n" +
                 "    <DatesBackup>" + dateBackUp + "</DatesBackup>\n" +
                 "    <TimeBackup>" + cfBackup.getBackupTime() + "</TimeBackup>\n" +
                 "    <Emails>" + cfBackup.getEmail().trim() + "</Emails>\n" +
                 "    <StatusBackup>" + String.valueOf(cfBackup.isCheckBackup()) + "</StatusBackup>\n" +
                 "    <LastBackUp>" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "</LastBackUp>\n" +
                 "    <CheckBackUp>" + "false" + "</CheckBackUp>\n" +
                 "</data>");
         /*cfBackup.setSuccess(true);*/
         if (!cfBackup.isCheckBackup())
             message = getText("v3.backup.stop");
         else message = getText("msg.save.backup.succes");

         return SUCCESS;
         /*if (cfBackup.isCheckBackup() == true) return SUCCESS;
         else return "successInit";*/
         //return new ModelAndView("redirect:/system/backup-view");

     }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ConfigBackupDatabaseForm getCfBackup() {
        return cfBackup;
    }

    public void setCfBackup(ConfigBackupDatabaseForm cfBackup) {
        this.cfBackup = cfBackup;
    }
}
