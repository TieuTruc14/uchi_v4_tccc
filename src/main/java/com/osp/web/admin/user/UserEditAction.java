package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by tieut on 9/30/2017.
 */
public class UserEditAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(UserEditAction.class);
    private int id;
    private User item;

    public String execute() {
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        try {
            if (id > 0) {
                item = beanUserDao.getUser(id);
                return INPUT;
            }
        } catch (Exception e) {
            logger.error("UserEditAction.execute:" + e.getMessage());
        }
        return INPUT;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getItem() {
        return item;
    }

    public void setItem(User item) {
        this.item = item;
    }

}
