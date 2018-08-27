package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.model.User;
import com.osp.persistence.AnnouncementDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementAddSaveAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(AnnouncementAddSaveAction.class);
    private Announcement item;
    private String message;

    public String execute(){
        AnnouncementDao beanAnnouncementDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            item.setDateCreated(new Date());
            User userContext = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            item.setUserCreated(userContext);
            Announcement itemReturn = beanAnnouncementDao.add(item);
            message = "thêm mới thành công";
        }catch (Exception e){
            logger.error("AnnouncementAddSaveAction"+e.getMessage());
            return INPUT;
        }
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Announcement getItem() {
        return item;
    }

    public void setItem(Announcement item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void validate(){

        if(StringUtils.isBlank(item.getTitle())){
            addFieldError("item.title", "Không bỏ trống trường này!");
        }
        if(StringUtils.isBlank(item.getContent())){
            addFieldError("item.content", "Không bỏ trống trường này!");
        }
        /*if(StringUtils.isBlank(item.getContent())){
            addFieldError("item.content","Không bỏ trống trường này!");
        }*/

    }

}
