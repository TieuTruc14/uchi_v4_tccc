package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by tieut on 9/30/2017.
 */
public class UserAddAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(UserDetailAction.class);
    private User item;

    public String execute() throws Exception {
        return "success";
    }

    public User getItem() {
        return item;
    }

    public void setItem(User item) {
        this.item = item;
    }

}
