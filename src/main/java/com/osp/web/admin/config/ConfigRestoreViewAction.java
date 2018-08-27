
package com.osp.web.admin.config;

import com.osp.common.web.AbstractAction;
import com.osp.model.ConfigBackupDatabaseForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Admin on 31/10/2017.
 */

public class ConfigRestoreViewAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ConfigRestoreViewAction.class);
    private String message;
    /*private ConfigBackupDatabaseForm cfBackup;*/

    public String execute() throws Exception{
        /*if(cfBackup!= null){
            String check = cfBackup.getFileRestore();
            System.out.println(check);
        }*/

        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   /* public ConfigBackupDatabaseForm getCfBackup() {
        return cfBackup;
    }

    public void setCfBackup(ConfigBackupDatabaseForm cfBackup) {
        this.cfBackup = cfBackup;
    }*/
}

