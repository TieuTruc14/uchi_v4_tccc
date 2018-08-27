package com.osp.model;

/**
 * Created by Admin on 27/10/2017.
 */
public class ConfigBackupDatabaseForm {
    private String pathBackUp;

    private boolean checkBackup;

    private String backupTime;

    private boolean mon;

    private boolean tue;

    private boolean wed;

    private boolean thu;

    private boolean fri;

    private boolean sat;

    private boolean sun;

    private String fileRestore;

    private String email;


    public ConfigBackupDatabaseForm() {
    }

    public ConfigBackupDatabaseForm(String pathBackUp, boolean checkBackup, String backupTime, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat, boolean sun, String fileRestore, String email) {
        this.pathBackUp = pathBackUp;
        this.checkBackup = checkBackup;
        this.backupTime = backupTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.fileRestore = fileRestore;
        this.email = email;

    }

    public String getPathBackUp() {
        return pathBackUp;
    }

    public void setPathBackUp(String pathBackUp) {
        this.pathBackUp = pathBackUp;
    }

    public boolean isCheckBackup() {
        return checkBackup;
    }

    public void setCheckBackup(boolean checkBackup) {
        this.checkBackup = checkBackup;
    }

    public String getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(String backupTime) {
        this.backupTime = backupTime;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public String getFileRestore() {
        return fileRestore;
    }

    public void setFileRestore(String fileRestore) {
        this.fileRestore = fileRestore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
