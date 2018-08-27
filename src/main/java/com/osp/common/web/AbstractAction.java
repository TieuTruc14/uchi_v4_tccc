package com.osp.common.web;

import com.osp.model.Text;
import com.osp.persistence.TextDao;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by tieut on 10/19/2017.
 */
public class AbstractAction  extends DefaultActionSupport implements ApplicationContextAware {
    protected static final String POST = "POST";
    protected static final String GET = "GET";

    protected ApplicationContext applicationContext;

    protected ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    protected Validator validator = factory.getValidator();

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    public Object getBean(String strBeanName) {
        return this.applicationContext.getBean(strBeanName);
    }

    public boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected String getParameter(String name) {
        return ServletActionContext.getRequest().getParameter(name);
    }

    protected String getCoookie(String name) {
        Cookie ck[] = ServletActionContext.getRequest().getCookies();
        for (int i = 0; i < ck.length; i++) {
            if (ck[i].getName().toLowerCase().equals(name.toLowerCase()))
                return ck[i].getValue();
        }
        return null;
    }

    protected void addCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        ServletActionContext.getResponse().addCookie(cookie);
    }
    protected HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }

    public  String getTitleText(String key){
        TextDao beanTextDao=(TextDao)this.getBean("beanTextDao");
        Text text=beanTextDao.getText(key);
        String name="";
        String type=getText("original_type");
        switch (type){
            case "1":
                name=text.getValue();
                break;
            case "0":
                name=text.getValue1();
                break;
        }

        return name;
    }

}
