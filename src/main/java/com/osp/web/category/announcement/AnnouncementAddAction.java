package com.osp.web.category.announcement;

import com.osp.common.web.AbstractAction;
import com.osp.model.Announcement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementAddAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(AnnouncementAddAction.class);
    private Announcement item;


    public String execute() throws Exception{

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
}
