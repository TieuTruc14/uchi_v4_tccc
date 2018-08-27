package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.persistence.AnnouncementDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementDetailAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(AnnouncementDetailAction.class);
    private Announcement item;
    private int id;
    public String execute() throws Exception{
        AnnouncementDao beanAnnouncementDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            item =beanAnnouncementDao.getAnnouncement(id);

        }catch (Exception e){
            logger.error("AnnouncementDetailAction"+e.getMessage());
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
