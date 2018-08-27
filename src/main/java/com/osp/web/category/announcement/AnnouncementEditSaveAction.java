package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.model.User;
import com.osp.persistence.AnnouncementDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementEditSaveAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(AnnouncementEditSaveAction.class);

    private Announcement item;
    private String message;

    public String execute() throws Exception {
        AnnouncementDao beanAnnouncementDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            Announcement itemDB = beanAnnouncementDao.getAnnouncement(item.getId());
            if(itemDB == null) return INPUT;

            changeValueAnnouncement(itemDB,item);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            itemDB.setDateUpdated(new Date());
            itemDB.setUserUpdated(user);

            beanAnnouncementDao.edit(itemDB);
            message = " cập nhật thành công";

        }catch (Exception e){
            logger.error("ManualEditSaveAction"+e.getMessage());
        }
        return SUCCESS;
    }
    public void changeValueAnnouncement(Announcement itemDB, Announcement item){

        itemDB.setTitle(item.getTitle());
        itemDB.setContent(item.getContent());
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
}
