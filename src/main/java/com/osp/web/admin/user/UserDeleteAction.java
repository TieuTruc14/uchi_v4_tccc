package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class UserDeleteAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(UserDetailAction.class);
    String message;

    public String execute() {
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        String idUser = getParameter("id");
        try {
            if (!StringUtils.isBlank(idUser)) {
                if (Integer.parseInt(idUser) > 0) {
                    User item = beanUserDao.getUser(Integer.parseInt(idUser));
                    item.setDateUpdated(new Date());
                    item.setDeleted(true);
                    beanUserDao.edit(item);
                    addActionMessage("Xóa tài khoản thành công");
                    message = "Xóa tài khoản thành công";
                }else{
                    addActionMessage("Xóa tài khoản thất bại, tài khoản không tồn tại!");
                    message = "Xóa tài khoản thất bại, tài khoản không tồn tại!";
                    return ERROR;
                }
            } else {
                addActionMessage("Xóa tài khoản thất bại, tài khoản không tồn tại!");
                message = "Xóa tài khoản thất bại, tài khoản không tồn tại!";
                return ERROR;
            }
        } catch (Exception e) {
            logger.error("com.osp.web.admin.user.UserDetailAction.execute" + e.getMessage());
            message = "Xóa tài khoản thất bại!";
            return ERROR;
        }
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
