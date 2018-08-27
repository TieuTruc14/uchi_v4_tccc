package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.persistence.AnnouncementDao;
import com.osp.web.category.manual.ManualDeleteAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementDeleteAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ManualDeleteAction.class);
    private int id;
    private String message;

    public String execute() throws Exception{
        AnnouncementDao beanAnnouncentDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            Announcement itemGet = beanAnnouncentDao.getAnnouncement(id);
            beanAnnouncentDao.deleteAnnouncement(itemGet);
            message = "xóa thành công ";

        }catch (Exception e){
            logger.error("AnnouncementDeleteAction"+e.getMessage());
        }
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
