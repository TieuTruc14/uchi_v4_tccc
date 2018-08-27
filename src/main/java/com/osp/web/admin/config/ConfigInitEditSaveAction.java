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
 * Created by Admin on 30/10/2017.
 */
public class ConfigInitEditSaveAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ConfigEditSaveAction.class);
    private String message;
    private ConfigBackupDatabaseForm cfBackup ;

    public String execute() throws Exception{
         /*if (cfBackupForm.getPathBackUp() != null && cfBackupForm.getPathBackUp().length() > 0) {
             if (cfBackupForm.getPathBackUp().trim().indexOf(" ") > 0) {
                 cfBackupForm.setSuccess(false);
                 cfBackupForm.setAction_status(SystemMessageProperties.getSystemProperty("err_cfg_backup_filepath"));
                 return new ModelAndView("/system/SM0014", "cfBackup", cfBackupForm);
             }
         } else {
             cfBackupForm.setSuccess(false);
             cfBackupForm.setAction_status(SystemMessageProperties.getSystemProperty("err_cfg_backup_not_filepath"));
             return new ModelAndView("/system/SM0014", "cfBackup", cfBackupForm);
         }*/


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
                "    <StatusBackup>" +"true"+ "</StatusBackup>\n" +
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
