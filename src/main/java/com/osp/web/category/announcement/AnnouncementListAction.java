package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import com.osp.model.User;
import com.osp.persistence.AnnouncementDao;
import com.osp.persistence.PagingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementListAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(AnnouncementListAction.class);
    private String message;
    private PagingResult page = new PagingResult();
    private String filterAnnouncementName;
    private User user;

    public String execute(){
        AnnouncementDao announcementDao = (AnnouncementDao)this.getBean("beanAnnouncementDao");
        try{
            announcementDao.pageAnnouncement(page,filterAnnouncementName);
            List<Announcement> items=announcementDao.listAnnouncement();
            System.out.println(items.get(0).getUserCreated().getId());

        }catch (Exception e){
            logger.error("AnnouncementListAction"+e.getMessage());
        }
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PagingResult getPage() {
        return page;
    }

    public void setPage(PagingResult page) {
        this.page = page;
    }

    public String getFilterAnnouncementName() {
        return filterAnnouncementName;
    }

    public void setFilterAnnouncementName(String filterAnnouncementName) {
        this.filterAnnouncementName = filterAnnouncementName;
    }

}
