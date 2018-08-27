package com.osp.web.admin.grant;

import com.osp.common.web.AbstractAction;
import com.osp.model.*;
import com.osp.persistence.GrantDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tieut on 10/20/2017.
 */
public class GrantGroupAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(GrantGroupAction.class);
    private String id;
    private Group group;
    private GrantGroupPermission page=new GrantGroupPermission();

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
            List<GroupGrant> items=beanGrantDao.listGroupGrant();
//            List<PermissionGroupGrant> listAdd=new ArrayList<>();
            if(items!=null && items.size()>0){
                for(GroupGrant item:items){
                    switch (item.getType()){
                        case 1:
                            page.getSystems().add(item);
                            break;
                        case 2:
                            page.getFunctions().add(item);
                            break;
                        case 3:
                            page.getReports().add(item);
                            break;
                        case 4:
                            page.getCategories().add(item);
                            break;
                        default:
                            break;
                    }
                }
            }
//            beanGrantDao.saveOrUpdatePermissionGroupGrants(listAdd);
            List<PermissionGroupGrant> listPermissionGroupGrant=beanGrantDao.listPermissionGroupGrant();
            HashMap<String,String> map=new HashMap<>();
            if(listPermissionGroupGrant!=null && listPermissionGroupGrant.size()>0){
                for(PermissionGroupGrant item:listPermissionGroupGrant){
                    map.put(item.getPermissionId(),item.getGroupGrantId().getId());
                }
            }

            List<GroupPermission> listPermission=beanGrantDao.listGroupPermissionByGroup(id);
            if(listPermission!=null && listPermission.size()>0){
                for(GroupPermission item:listPermission){
                    if(map.get(item.getPermissionId())!=null){
                        switch (checkGroupGrant(map.get(item.getPermissionId()),page)){
                            case 1:
                                page.getListSystem().append(item.getPermissionId()+",");
                                break;
                            case 2:
                                page.getListFunction().append(item.getPermissionId()+",");
                                break;
                            case 3:
                                page.getListReport().append(item.getPermissionId()+",");
                                break;
                            case 4:
                                page.getListCategory().append(item.getPermissionId()+",");
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        }catch (Exception e){
            logger.error("GrantGroupAction.execute:"+e.getMessage());
        }
        return SUCCESS;
    }

    private boolean checkGroupGrantPermission(String key, List<GroupGrant> items){
        if(StringUtils.isBlank(key) || items==null || items.size()<1){
            return false;
        }
        for(GroupGrant item:items){
            if(key.equals(item.getId())){
                return true;
            }
        }
        return false;
    }

    private int checkGroupGrant(String key, GrantGroupPermission page){
        if(StringUtils.isBlank(key)){
            return 0;
        }
        if(checkGroupGrantPermission(key,page.getSystems())){
            return 1;
        }
        if(checkGroupGrantPermission(key,page.getFunctions())){
            return 2;
        }
        if(checkGroupGrantPermission(key,page.getReports())){
            return 3;
        }
        if(checkGroupGrantPermission(key,page.getCategories())){
            return 4;
        }
        return 0;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GrantGroupPermission getPage() {
        return page;
    }

    public void setPage(GrantGroupPermission page) {
        this.page = page;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
