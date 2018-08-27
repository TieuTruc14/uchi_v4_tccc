package com.osp.web.category.bank;

import com.osp.common.web.AbstractAction;
import com.osp.model.Bank;
import com.osp.persistence.BankDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 26/10/2017.
 */
public class BankDetailAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(BankDetailAction.class);
    private String id;
    private Bank item;

    public String execute()throws Exception{
        BankDao beanBankDao = (BankDao)this.getBean("beanBankDao");
        try{
            item= beanBankDao.getBankByBankId(id);
        }catch (Exception e){
            logger.error("beanBankDao"+e.getMessage());
        }

        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bank getItem() {
        return item;
    }

    public void setItem(Bank item) {
        this.item = item;
    }
}
