package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by tieut on 9/30/2017.
 */
public class UserResetPasswordAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(UserDetailAction.class);
    private User item;
    private int id;
    private String password;
    private String newPassword;
    private String reNewPassword;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private String message = "";


    public String execute() throws Exception {
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            if (user == null) return INPUT;
            if (item == null) {
                if (id == 0) return INPUT;
                item = beanUserDao.getUser(id);
                return INPUT;
            } else {
                item = beanUserDao.getUser(id);
                item.setPassword(newPassword);
                //item.setPassword(encoder.encode(newPassword));
                beanUserDao.add(item);
                addActionMessage("Reset password thành công!");
                message = "Reset password thành công!";
            }
        } catch (Exception e) {
            logger.error("com.osp.web.admin.user.UserResetPasswordAction.execute:" + e.getMessage());
        }
        return SUCCESS;
    }

    public String changePass() {
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            if (user == null) return ERROR;
            if (item == null) {
                if (id == 0) return INPUT;
                item = beanUserDao.getUser(user.getId());
                return INPUT;
            } else {
                if (StringUtils.isBlank(newPassword)) {
                    addFieldError("newPassword", "Không bỏ trống trường này!");
                    return INPUT;
                }
                if (StringUtils.isBlank(reNewPassword)) {
                    addFieldError("reNewPassword", "Không bỏ trống trường này!");
                    return INPUT;
                }
                if (!StringUtils.isBlank(reNewPassword) && !StringUtils.isBlank(newPassword)) {
                    if (!reNewPassword.equals(newPassword)) {
                        addFieldError("newPasswordNotEqual", "Mật khẩu mới nhập lại không đúng!");
                        return INPUT;
                    }
                }
                item = beanUserDao.getUser(user.getId());
                //item.setPassword(encoder.encode(newPassword));
                item.setPassword(newPassword);
                beanUserDao.edit(item);
                addActionMessage("Đổi mật khẩu thành công!");
            }


        } catch (Exception e1) {
            logger.error("changePass error :" + e1.getMessage());
            e1.printStackTrace();
        }
        return SUCCESS;
    }

    public String resetPass() {
        return SUCCESS;
    }

    public User getItem() {
        return item;
    }

    public void setItem(User item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public void validate() {
        if (item != null) {
            if (StringUtils.isBlank(item.getPassword())) {
                if (!StringUtils.isBlank(newPassword)) {
                    item.setPassword(newPassword);
                }else{
                    addFieldError("item.password", "Không bỏ trống trường này!");
                }
            }
            if (newPassword.length() < 8) {
                addFieldError("item.password", "Mật khẩu phải dài tối thiểu 6 kí tự!");
            }
        }
    }
}
