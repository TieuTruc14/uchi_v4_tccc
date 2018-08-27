package com.osp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/20/2017.
 */
public class GrantGroupPermission {

    private List<GroupGrant> systems=new ArrayList<>();
    private List<GroupGrant> functions=new ArrayList<>();
    private List<GroupGrant> reports=new ArrayList<>();
    private List<GroupGrant> categories=new ArrayList<>();

    private StringBuilder listSystem=new StringBuilder("");
    private StringBuilder listFunction=new StringBuilder("");
    private StringBuilder listReport=new StringBuilder("");
    private StringBuilder listCategory=new StringBuilder("");

    public List<GroupGrant> getSystems() {
        return systems;
    }

    public void setSystems(List<GroupGrant> systems) {
        this.systems = systems;
    }

    public List<GroupGrant> getFunctions() {
        return functions;
    }

    public void setFunctions(List<GroupGrant> functions) {
        this.functions = functions;
    }

    public List<GroupGrant> getReports() {
        return reports;
    }

    public void setReports(List<GroupGrant> reports) {
        this.reports = reports;
    }

    public StringBuilder getListSystem() {
        return listSystem;
    }

    public void setListSystem(StringBuilder listSystem) {
        this.listSystem = listSystem;
    }

    public StringBuilder getListFunction() {
        return listFunction;
    }

    public void setListFunction(StringBuilder listFunction) {
        this.listFunction = listFunction;
    }

    public StringBuilder getListReport() {
        return listReport;
    }

    public void setListReport(StringBuilder listReport) {
        this.listReport = listReport;
    }

    public List<GroupGrant> getCategories() {
        return categories;
    }

    public void setCategories(List<GroupGrant> categories) {
        this.categories = categories;
    }

    public StringBuilder getListCategory() {
        return listCategory;
    }

    public void setListCategory(StringBuilder listCategory) {
        this.listCategory = listCategory;
    }
}
