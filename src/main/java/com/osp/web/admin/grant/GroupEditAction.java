package com.osp.web.admin.grant;

import com.osp.common.web.AbstractAction;
import com.osp.model.Group;
import com.osp.model.User;
import com.osp.persistence.GrantDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by tieut on 10/20/2017.
 */
public class GroupEditAction extends AbstractAction {
    private static final long serialVersionUID = -5834031847483438477L;
    private Logger logger= LogManager.getLogger(GroupListAction.class);
    private String id;
    private Group item;

    public String execute() throws Exception {
        GrantDao beanGrantDao=(GrantDao) this.getBean("beanGrantDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return "403";
        try{
            if(StringUtils.isBlank(id)) return "404";
            item=beanGrantDao.getGroup(id);
            if(item==null) return "404";
        }catch (Exception e){
            logger.error("GroupEditAction.execute:"+e.getMessage());
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
}
