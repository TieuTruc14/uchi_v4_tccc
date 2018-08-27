package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.PagingResult;
import com.osp.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 9/15/2017.
 */
public class UserListAction extends AbstractAction {
    private static final long serialVersionUID = -8217092856258602097L;
    private Logger logger= LogManager.getLogger(UserListAction.class);
    private PagingResult page = new PagingResult();
    private String filterUserName;
    private String message="";


    public String execute(){
        UserDao beanUserDao=(UserDao)this.getBean("beanUserDao");
        beanUserDao.pageUser(page,filterUserName);
        PagingResult page1 = new PagingResult();
        beanUserDao.pageTest(page);
        return SUCCESS;
    }


    public PagingResult getPage() {
        return page;
    }

    public void setPage(PagingResult page) {
        this.page = page;
    }

    public String getFilterUserName() {
        return filterUserName;
    }

    public void setFilterUserName(String filterUserName) {
        this.filterUserName = filterUserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
