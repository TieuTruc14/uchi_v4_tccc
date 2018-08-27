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
public class UserEditSaveAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(UserEditSaveAction.class);
    private int   id;
    private User item;
    private String message;
    private String position;
    public String execute(){
        UserDao beanUserDao=(UserDao)this.getBean("beanUserDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        item.setUserUpdated(user);
        item.setDateUpdated(new Date());
        item.setPosition(position);
        try{
            if(item==null){
                return INPUT;
            }
            User userEdit=beanUserDao.getUser(item.getId());
            if(userEdit==null) return INPUT;
            changeValueUser(userEdit,item);
            beanUserDao.edit(userEdit);
            message="Sửa thông tin thành công!";
        }catch (Exception e){
            logger.error("UserEditSaveAction.execute:"+e.getMessage());
        }
        return SUCCESS;
    }

    private void changeValueUser(User userDB,User userAction){
//        userDB.setName(userAction.getName());
        userDB.setEmail(userAction.getEmail());
        userDB.setAddress(userAction.getAddress());
        userDB.setPhone(userAction.getPhone());
        userDB.setBirthday(userAction.getBirthday());
        userDB.setDisable(userAction.isDisable());
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
        if(StringUtils.isBlank(item.getUsername().trim())){
            addFieldError("item.username", "Tài khoản đăng nhập không được để trống !");
        }else if (item.getUsername().length() < 2){
            addFieldError("item.username", "Tài khoản đăng nhập phải dài tối thiểu 2 kí tự!");
        }
        if(StringUtils.isBlank(item.getEmail())){
            addFieldError("item.email", "Email không được bỏ trống!");
        }
//        if(StringUtils.isBlank(item.getName())){
//            addFieldError("item.name", "Họ tên không được bỏ trống!");
//        }
    }

}
