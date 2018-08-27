package com.osp.web.category.contracthistory;

import com.osp.common.web.AbstractAction;
import com.osp.model.ContractHistory;
import com.osp.model.User;
import com.osp.persistence.ContractHistoryDao;
import com.osp.persistence.PagingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by minh on 10/24/2017.
 */
public class ContractHistoryList extends AbstractAction {
    private Logger logger = LogManager.getLogger(ContractHistoryList.class);
    private String message;
    private PagingResult page = new PagingResult();
    private String filterContractHistory;
    private User user;
    public String execute(){
        ContractHistoryDao contractHistoryDao = (ContractHistoryDao)this.getBean("beanContractHistoryDao");
        try{
            contractHistoryDao.pageContractHistory(page,filterContractHistory);
            List<ContractHistory> items=contractHistoryDao.listContractHistory();
        }catch (Exception e){
            logger.error("ContractHistoryListAction"+e.getMessage());
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

    public String getFilterContractHistory() {
        return filterContractHistory;
    }

    public void setFilterContractHistory(String filterContractHistory) {
        this.filterContractHistory = filterContractHistory;
    }
}
