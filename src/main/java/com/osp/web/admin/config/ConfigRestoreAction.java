package com.osp.web.admin.config;

import com.osp.common.util.Constants;
import com.osp.common.web.AbstractAction;
import com.osp.model.ConfigBackupDatabaseForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 31/10/2017.
 */
public class ConfigRestoreAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ConfigRestoreAction.class);
    private ConfigBackupDatabaseForm cfBackup;
    private String message;
    public String execute() throws Exception{

        String filePath = cfBackup.getFileRestore();
        File file = new File(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER));
        if (!file.exists()) {
            file.mkdirs();
        }
        String database = getText("system.backup.database");
        String user = getText("system.backup.user");
        String pass = getText("system.backup.pass");
        String host = getText("system.backup.host");
        String port = getText("system.backup.port");

        /*String database = "uchiv3_stp";
        String user = "root";
        String pass = "";
        String host = "localhost";*/

        File fileBackUp = new File(filePath.replaceAll("\\\\", "/"));
        if (!fileBackUp.exists()) System.out.println("1");
        if (!fileBackUp.isDirectory()) System.out.println("2");
        if (!fileBackUp.canRead()) System.out.println("3");
        System.out.println("cmnr=" + filePath.replaceAll("\\\\", "/"));
        if (fileBackUp.exists() && !fileBackUp.isDirectory() && fileBackUp.canRead()) {
            System.out.println("exits");
            String[] cmd = new String[10];
            int i = 0;
            cmd[i++] = getText(Constants.CONFIG_MYSQL_DUMP_FOLDER).substring(0, 2);
            cmd[i++] = "cd \"" + getText(Constants.CONFIG_MYSQL_DUMP_FOLDER) + "\"";
            cmd[i++] = "mysql -u" + user + " -p" + pass + " -h" + host + " -P" + port + " " + database + " < \"" + filePath.replaceAll("\\\\", "/") + "\"";

            Runtime c = Runtime.getRuntime();
            String fileretore= Constants.FILE_NAME_RESTORE;
            if(getText("system.backup.os").equals("1")){
                fileretore="restore.sh";
            }
            createFileBackUpOrRetore(cmd, fileretore, i);
            String cmdStr = "cmd /c start " + getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER) + Constants.FILE_NAME_RESTORE;
            try {
                Process pro;
                if(getText("system.backup.os").equals("0")){
                    pro =c.exec(cmdStr, null);
                }else{
                    pro =c.exec(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER)+"restore.sh",
                            null, new File(Constants.CONFIG_BACKUP_DATABASE_FOLDER));

                }
                // Process pro = c.exec(cmdStr, null);
                if (pro.waitFor() == 0) {

                    message= getText("msg_restore_success");

                } else {

                    message = getText("err_restore_database");
                    return ERROR;

                }
            } catch (Exception e) {

               message = getText("err_restore_database");
               return ERROR;

            }
        } else {

            message = getText("err_restore_database_file_path");
            return ERROR;
        }
        return SUCCESS;
    }

    public void createFileBackUpOrRetore(String[] fileContent, String fileName, int length) {
        try {
            File file = new File(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER) + fileName);
            File folder = new File(getText(Constants.CONFIG_BACKUP_DATABASE_FOLDER));
            if (file.exists()) {
                file.delete();
            } else {
                if (!folder.exists())
                    folder.mkdirs();
            }
            file.createNewFile();

            file.setReadable(true, false);
            file.setExecutable(true, false);
            file.setWritable(true, false);
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (int i = 0; i < length; i++) {
                writer.println(fileContent[i]);
                System.out.println(fileContent[i]);
            }
            writer.println("exit");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
