package com.osp.web.contract.online;

import com.osp.common.web.AbstractAction;
import com.osp.model.Contract;
import com.osp.model.User;
import com.osp.persistence.ContractDao;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by tieut on 10/28/2017.
 */
public class GetContractById extends AbstractAction {
    private int id;
    private Contract item;
    public String execute(){
        ContractDao beanContractDao=(ContractDao) this.getBean("beanContractDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return SUCCESS;
        if(id>0){
            item=beanContractDao.getContract(id);
        }
        return SUCCESS;
    }

    public Contract getItem() {
        return item;
    }

    public void setId(int id) {
        this.id = id;
    }
}
