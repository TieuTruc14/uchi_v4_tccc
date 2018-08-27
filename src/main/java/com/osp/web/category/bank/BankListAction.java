package com.osp.web.category.bank;

import com.osp.common.web.AbstractAction;
import com.osp.persistence.BankDao;
import com.osp.persistence.PagingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by Admin on 26/10/2017.
 */
public class BankListAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(BankListAction.class);
    private PagingResult page = new PagingResult();
    private String message;
    private String filterBankName;
    private String filterBankCode;

    public String execute() throws Exception{
        BankDao beanBankDao = (BankDao)this.getBean("beanBankDao");
        try{
            beanBankDao.pageBank(page,filterBankName,filterBankCode);
        }catch (Exception e){
            logger.error("beanBankDao"+e.getMessage());
        }
        return SUCCESS;


    }

    public PagingResult getPage() {
        return page;
    }

    public void setPage(PagingResult page) {
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilterBankName() {
        return filterBankName;
    }

    public void setFilterBankName(String filterBankName) {
        this.filterBankName = filterBankName;
    }

    public String getFilterBankCode() {
        return filterBankCode;
    }

    public void setFilterBankCode(String filterBankCode) {
        this.filterBankCode = filterBankCode;
    }
}
