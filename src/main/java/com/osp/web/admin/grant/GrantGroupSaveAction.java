package com.osp.web.admin.grant;

import com.osp.common.web.AbstractAction;
import com.osp.model.*;
import com.osp.persistence.GrantDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/20/2017.
 */
public class GrantGroupSaveAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(GrantGroupSaveAction.class);
    private String id;
    private Group group;
    private GrantGroupPermission page=new GrantGroupPermission();
    private String listSystem;
    private String listFunction;
    private String listReport;
    private String listCategory;
    private String message;

    public String execute(){
        if(StringUtils.isBlank(id)) return "404";
        GrantDao beanGrantDao=(GrantDao) this.getBean("beanGrantDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return "403";
        try{
            group=beanGrantDao.getGroup(id);
            if(group==null){
                return "404";
            }
            List<GroupPermission> items=new ArrayList<>();
            items=genItemFromListString(listSystem,items);
            items=genItemFromListString(listFunction,items);
            items=genItemFromListString(listReport,items);
            items=genItemFromListString(listCategory,items);
            if(items.size()>0){
                beanGrantDao.deleteGroupPermissionByGroup(id);
                beanGrantDao.saveOrUpdateGroupPermissions(items);
            }
            message="Phân quyền thành công!";

        }catch (Exception e){
            logger.error("GrantGroupSaveAction.execute:"+e.getMessage());
        }
        return SUCCESS;
    }

    private List<GroupPermission> genItemFromListString(String listString,List<GroupPermission> items){
        if(!StringUtils.isBlank(listString)){
            String[] strings=listString.split(",");
            for(String sys:strings){
                if(!StringUtils.isBlank(sys)){
                    GroupPermission item=new GroupPermission();
                    item.setGroupId(id);
                    item.setPermissionId(StringUtils.trim(sys));
                    items.add(item);
                }
            }
        }
        return items;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GrantGroupPermission getPage() {
        return page;
    }

    public void setPage(GrantGroupPermission page) {
        this.page = page;
    }

    public String getListSystem() {
        return listSystem;
    }

    public void setListSystem(String listSystem) {
        this.listSystem = listSystem;
    }

    public String getListFunction() {
        return listFunction;
    }

    public void setListFunction(String listFunction) {
        this.listFunction = listFunction;
    }

    public String getListReport() {
        return listReport;
    }

    public void setListReport(String listReport) {
        this.listReport = listReport;
    }

    public String getListCategory() {
        return listCategory;
    }

    public void setListCategory(String listCategory) {
        this.listCategory = listCategory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
