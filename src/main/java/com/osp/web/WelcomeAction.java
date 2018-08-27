package com.osp.web;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;

import java.util.List;

/**
 * Created by tieut on 9/10/2017.
 */
public class WelcomeAction extends AbstractAction{
    private static final long serialVersionUID = -2115587885326571880L;

    public String execute() {
        return SUCCESS;
    }


}
