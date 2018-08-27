package com.osp.model;

import com.opensymphony.xwork2.ActionSupport;
import com.osp.common.util.EditString;
import com.osp.common.utils.AbstractBean;
import com.osp.common.web.AbstractAction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Admin on 30/10/2017.
 */
public class ConfigBackupDatabaseManager extends AbstractBean{
    private static final String file_name_bat = "backup.bat";
    /*private static final String CONFIG_MYSQL_FORDER = "system.mysql.mysqldump.folder";
    private static final String CONFIG_BACKUP_DATABASE_FOLDER = "system.backup.database.folder";
    private static final String TIME_BACKUP = "time.bacup";
    private static final String DATE_BACKUP = "date.backup";
    private String fileNameBat="backup.bat";*/
    private String configMySqlDumpFolder;
    private String configBackUpDatabaseFolder;
    private String timeBackUp;
    private String dateBackUp;
    private String systemBackUpOs;
    private String systemBackUpDatabase;
    private String systemBackUpUser;
    private String systemBackUpPass;
    private String systemBackUpHost;
    private String systemBackUpPort;



    public String createBackupFileBat() throws Exception{
        try {
            String filebat=file_name_bat;
            if(systemBackUpOs.equals("1")) filebat= "backup.sh";
            File file = new File(configBackUpDatabaseFolder + filebat);
            File folder = new File(configBackUpDatabaseFolder);
            if(file.exists()){
                file.delete();
            } else{
                if(!folder.exists())
                    folder.mkdirs();
            }
            file.createNewFile();
            file.setReadable(true, false);
            file.setExecutable(true, false);
            file.setWritable(true, false);
            String database = systemBackUpDatabase;
            String user = systemBackUpUser;
            String pass = systemBackUpPass;
            String host = systemBackUpHost;
            String port = systemBackUpPort;


            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.println("cd " + configMySqlDumpFolder);
            String oDia = configMySqlDumpFolder.substring(0, 2);
            writer.println(oDia);

            Calendar cal = Calendar.getInstance();
            String filename="backup-"+cal.get(Calendar.YEAR)+"-"+String.valueOf(cal.get(Calendar.MONDAY) + 1)+"-"+cal.get(Calendar.DATE)+"-"+cal.get(Calendar.HOUR_OF_DAY)+"-"+cal.get(Calendar.MINUTE)+"-"+cal.get(Calendar.SECOND)+".sql \"";

            writer.println("mysqldump -u" + user+ " -p" + pass + " -h" + host + " -P" + port + " "  + database + " -r \"" + configBackUpDatabaseFolder + filename);
            writer.println("exit");
            writer.close();
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void backUpAutomatic(){
        try {
//            createBackupFileBat();

            Runtime c = Runtime.getRuntime();
            String cmd = "cmd /c start " + configBackUpDatabaseFolder+ "backup.bat";
            if(systemBackUpOs.equals("0")){
                c.exec(cmd, null);
            }else{
                c.exec(configBackUpDatabaseFolder+"backup.sh",
                        null, new File(configBackUpDatabaseFolder));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean checkBackUp(){
        boolean result = false;
        String timeBackUp = getTimeBackUp();
        //int hour = Integer.parseInt(timeBackUp.substring(0, 2).replace(":","").trim());
        //int minute = Integer.parseInt(timeBackUp.substring(3, 5).replace(":","").trim());
        int hour = Integer.parseInt(timeBackUp.substring(0, timeBackUp.indexOf(":")).trim());
        int minute = Integer.parseInt(timeBackUp.substring(timeBackUp.indexOf(":")+1, timeBackUp.indexOf(":")+3).trim());
        String pa = timeBackUp.substring(6);

        Calendar cal = Calendar.getInstance();
        int index = Calendar.DAY_OF_WEEK;
        if(cal.get(Calendar.DAY_OF_WEEK) == 1){
            index = 6;
        } else{
            index = cal.get(Calendar.DAY_OF_WEEK) - 2;
        }
        String dateBackUp = getDateBackUp();
        List<Boolean> listDatebackup = EditString.parseListDateBackup(dateBackUp);
        if(listDatebackup.get(index)){
            if(pa.equals("AM")){
                if(hour == cal.get(Calendar.HOUR_OF_DAY)){
                    if(minute == cal.get(Calendar.MINUTE)){
                        result = true;
                    } else{
                        result = false;
                    }
                } else{
                    result = false;
                }
            } else{
                if((hour + 12) == cal.get(Calendar.HOUR_OF_DAY)){
                    if(minute == cal.get(Calendar.MINUTE)){
                        result = true;
                    } else{
                        result = false;
                    }
                } else{
                    result = false;
                }
            }
        } else{
            return false;
        }
        return result;
    }

    public String getConfigMySqlDumpFolder() {
        return configMySqlDumpFolder;
    }

    public void setConfigMySqlDumpFolder(String configMySqlDumpFolder) {
        this.configMySqlDumpFolder = configMySqlDumpFolder;
    }

    public String getConfigBackUpDatabaseFolder() {
        return configBackUpDatabaseFolder;
    }

    public void setConfigBackUpDatabaseFolder(String configBackUpDatabaseFolder) {
        this.configBackUpDatabaseFolder = configBackUpDatabaseFolder;
    }

    public String getTimeBackUp() {
        return timeBackUp;
    }

    public void setTimeBackUp(String timeBackUp) {
        this.timeBackUp = timeBackUp;
    }

    public String getDateBackUp() {
        return dateBackUp;
    }

    public void setDateBackUp(String dateBackUp) {
        this.dateBackUp = dateBackUp;
    }

    public String getSystemBackUpOs() {
        return systemBackUpOs;
    }

    public void setSystemBackUpOs(String systemBackUpOs) {
        this.systemBackUpOs = systemBackUpOs;
    }

    public String getSystemBackUpDatabase() {
        return systemBackUpDatabase;
    }

    public void setSystemBackUpDatabase(String systemBackUpDatabase) {
        this.systemBackUpDatabase = systemBackUpDatabase;
    }

    public String getSystemBackUpUser() {
        return systemBackUpUser;
    }

    public void setSystemBackUpUser(String systemBackUpUser) {
        this.systemBackUpUser = systemBackUpUser;
    }

    public String getSystemBackUpPass() {
        return systemBackUpPass;
    }

    public void setSystemBackUpPass(String systemBackUpPass) {
        this.systemBackUpPass = systemBackUpPass;
    }

    public String getSystemBackUpHost() {
        return systemBackUpHost;
    }

    public void setSystemBackUpHost(String systemBackUpHost) {
        this.systemBackUpHost = systemBackUpHost;
    }

    public String getSystemBackUpPort() {
        return systemBackUpPort;
    }

    public void setSystemBackUpPort(String systemBackUpPort) {
        this.systemBackUpPort = systemBackUpPort;
    }
}
