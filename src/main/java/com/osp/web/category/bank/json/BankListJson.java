package com.osp.web.category.bank.json;

import com.osp.common.web.AbstractAction;
import com.osp.model.Bank;
import com.osp.model.User;
import com.osp.persistence.BankDao;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * Created by tieut on 10/28/2017.
 */
public class BankListJson extends AbstractAction {
    private List<Bank> items;

    public String execute(){
        BankDao beanBankDao=(BankDao) this.getBean("beanBankDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return SUCCESS;
        items=beanBankDao.listOrderAndEnable();
        return SUCCESS;
    }

    public List<Bank> getItems() {
        return items;
    }
}
