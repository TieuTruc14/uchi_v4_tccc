package com.osp.web.admin.grant;

import com.osp.common.web.AbstractAction;
import com.osp.model.Group;
import com.osp.model.User;
import com.osp.persistence.GrantDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * Created by tieut on 10/19/2017.
 */
public class GroupAddSaveAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(GroupListAction.class);
    private Group item;
    private String message="";

    public String execute() throws Exception {
        GrantDao beanGrantDao=(GrantDao) this.getBean("beanGrantDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return "403";
        try{
            Group checkExits=beanGrantDao.getGroup(item.getId());
            if(checkExits!=null){
                addActionError("Mã đối tượng đã tồn tại!");
                return INPUT;
            }
            item.setUserCreated(user);
            item.setUserUpdated(user);
            item.setDateCreated(new Date());
            item.setDateUpdated(new Date());
            item=beanGrantDao.addGroup(item);
            message="Thêm nhóm quyền thành công!";
        }catch (Exception e){
            logger.error("GroupAddSaveAction.execute:"+e.getMessage());
        }

        return SUCCESS;
    }

    public Group getItem() {
        return item;
    }

    public void setItem(Group item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void validate(){
        if(StringUtils.isBlank(item.getId())){
            addFieldError("item.id", "Trường này không được để trống!");
        }else if(item.getId().length()<item.getId().replaceAll(" ","").length()){
            addFieldError("item.id", "Trường này không được chứa khoảng trắng!");
        }
        if(StringUtils.isBlank(item.getName())){
            addFieldError("item.name", "Trường này không được để trống!");
        }
    }
}
