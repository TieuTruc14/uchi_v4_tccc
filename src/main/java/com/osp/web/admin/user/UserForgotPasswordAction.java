package com.osp.web.admin.user;

import com.osp.service.mail.MailUtil;
import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;

public class UserForgotPasswordAction extends AbstractAction {
    public String username;
    public String email;

    @Override
    public String execute() throws Exception {
        username = getParameter("account");
        email = getParameter("email");
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        MailUtil beanMailUtil = (MailUtil) this.getBean("beanMailUtil");
        User user = null;
        String linkLogin = "http://" + getDomainName(getRequestURL(getRequest())) + getRequest().getContextPath() + "/login.html";
        if (StringUtils.isBlank(username)) {
            addFieldError("username_notnull","Bạn chưa nhập tên tài khoản!");
            return INPUT;
        } else {
            user = beanUserDao.getUserByUsername(username);
        }
        if (user != null) {
            if (StringUtils.isBlank(email)) {
                addFieldError("username_notnull","Bạn chưa nhập tên email!");
                return INPUT;
            } else {
                if(!email.equals(user.getEmail())){
                    addActionError("Email bạn nhập không khớp với email của tài khoản!");
                    return INPUT;
                }
            }
        }else{
            addActionError("Tài khoản không tồn tại!");
            return INPUT;
        }
        String newPass = new BigInteger(130, new SecureRandom()).toString(32);
        user.setPassword(newPass);
        beanUserDao.edit(user);
        boolean mail = beanMailUtil.mail(user.getEmail(), newPass, user.getUsername(), linkLogin);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void validate() {
        if (StringUtils.isBlank(username)) {
            addFieldError("username_notnull","Bạn chưa nhập tên tài khoản!");
        }
        if (StringUtils.isBlank(email)) {
            addFieldError("email_notnull","Bạn chưa nhập tên email!");
        }
    }

    public String getDomainName(String url) {
        URI uri;
        String domain = "";
        try {
            uri = new URI(url);
            domain = uri.getPort() > 0 ? uri.getHost() + ":" + uri.getPort() : uri.getHost();
            domain = domain.startsWith("www.") ? domain.substring(4) : domain;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return domain;
    }

    public String getRequestURL(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }
}
