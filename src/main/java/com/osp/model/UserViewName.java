package com.osp.model;

/**
 * Created by tieut on 9/12/2017.
 */
public class UserViewName {
    private int id;
    private String name;

    public UserViewName() {
    }

    public UserViewName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
