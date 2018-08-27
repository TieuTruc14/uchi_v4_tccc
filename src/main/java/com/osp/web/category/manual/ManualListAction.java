package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.persistence.ManualDao;
import com.osp.persistence.PagingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * Created by Admin on 17/10/2017.
 */
public class ManualListAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ManualListAction.class);
    private String message;
    private PagingResult page = new PagingResult();
    private String filterManualName;

    public String execute(){
        ManualDao manualDao = (ManualDao)this.getBean("beanManualDao");
        try{
            manualDao.pageManual(page,filterManualName);
        }catch (Exception e){
            logger.error("ManualListAction"+e.getMessage());
        }
        return SUCCESS;
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

    public String getFilterManualName() {
        return filterManualName;
    }

    public void setFilterManualName(String filterManualName) {
        this.filterManualName = filterManualName;
    }
}
