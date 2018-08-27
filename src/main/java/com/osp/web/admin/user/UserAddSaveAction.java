package com.osp.web.admin.user;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * Created by tieut on 9/30/2017.
 */
public class UserAddSaveAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(UserDetailAction.class);
    private User item;
    private String confirmPassword;
    private String message;
    private String position;

    //^[a-zA-Z0-9_.-]*$
    //^([a-zA-Z0-9]+[_-])*[a-zA-Z0-9]+\.[a-zA-Z0-9]+$

    public String execute() throws Exception {
        UserDao beanUserDao=(UserDao)this.getBean("beanUserDao");
        try{
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(user==null) return INPUT;
            User exits=beanUserDao.getUserByUsername(item.getUsername());
            if(exits!=null){
                return INPUT;
            }
            item.setUserCreated(user);
            item.setUserUpdated(user);
            item.setDateCreated(new Date());
            item.setDateUpdated(new Date());
            item.setPosition(position);
            item.setId(Integer.valueOf(7));
            beanUserDao.add(item);
            message="Thêm tài khoàn thành công!";
        }catch (Exception e){
            logger.error("com.osp.web.admin.user.UserAddSaveAction.execute:"+e.getMessage());
        }
        return SUCCESS;
    }

    public User getItem() {
        return item;
    }

    public void setItem(User item) {
        this.item = item;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void validate(){
        if(StringUtils.isBlank(item.getUsername())){
            addFieldError("item.username", "Tài khoản đăng nhập không được để trống !");
        }else if (item.getUsername().length() < 2){
            addFieldError("item.username", "Tài khoản đăng nhập phải dài tối thiểu 2 kí tự!");
        }
        if(StringUtils.isBlank(item.getPassword())){
            addFieldError("item.password", "Mật khẩu không được bỏ trống!");
        }else{
            if (StringUtils.isBlank(item.getPassword())){
                addFieldError("item.password","Mật khẩu không được để trống!");
            }else if(StringUtils.isBlank(confirmPassword)){
                addFieldError("confirmPassword", "Chưa xác nhận mật khẩu!");
            }else if(!confirmPassword.equals(item.getPassword())){
                addFieldError("confirmPassword", "Mật khẩu nhập lại không trùng khớp với mật khẩu!");
            }
        }
        if(StringUtils.isBlank(item.getEmail())){
            addFieldError("item.email", "Email không được bỏ trống!");
        }
//        if(StringUtils.isBlank(item.getName())){
//            addFieldError("item.name", "Họ tên không được bỏ trống!");
//        }
    }
}
