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
 * Created by tieut on 10/20/2017.
 */
public class GroupEditSaveAction extends AbstractAction {
    private static final long serialVersionUID = 4471596857497640786L;
    private Logger logger= LogManager.getLogger(GroupEditSaveAction.class);
    private String id;
    private Group item;
    private String message;

    public String execute(){
        GrantDao beanGrantDao=(GrantDao) this.getBean("beanGrantDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return "403";

        try{
            if(StringUtils.isBlank(id)) return "404";
            Group itemDB=beanGrantDao.getGroup(id);
            if(itemDB==null) return "404";
            itemDB.setName(item.getName());
            itemDB.setDescription(item.getDescription());
            itemDB.setDateUpdated(new Date());
            itemDB.setUserUpdated(user);
            itemDB=beanGrantDao.editGroup(itemDB);
            message="Sửa đối tượng thành công!";
        }catch (Exception e){
            logger.error("GroupEditSaveAction.execute:"+e.getMessage());
        }
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if(StringUtils.isBlank(id)){
            addFieldError("id", "Id đối tượng không đúng!");
        }
        if(StringUtils.isBlank(item.getName())){
            addFieldError("item.name", "Trường này không được để trống!");
        }
    }
}
