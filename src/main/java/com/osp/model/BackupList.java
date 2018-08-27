package com.osp.model;

import java.util.ArrayList;

/**
 * Created by Admin on 31/10/2017.
 */
public class BackupList {
    private ArrayList<BackupInfo> list;
    private String filename;

    public BackupList() {
    }

    public ArrayList<BackupInfo> getList() {
        return list;
    }

    public void setList(ArrayList<BackupInfo> list) {
        this.list = list;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
