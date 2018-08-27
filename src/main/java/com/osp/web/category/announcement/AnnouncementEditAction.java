package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.persistence.AnnouncementDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementEditAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(AnnouncementEditAction.class);
    private int id;
    private Announcement item;
    public String execute() throws Exception{
        AnnouncementDao beanAnnouncementDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            item = beanAnnouncementDao.getAnnouncement(id);
        }catch (Exception e){
            logger.error("AnnouncementEditAction"+e.getMessage());
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

    public Announcement getItem() {
        return item;
    }

    public void setItem(Announcement item) {
        this.item = item;
    }

}
