package com.osp.web.contract;

import com.osp.common.web.AbstractAction;
import com.osp.model.ContractNumber;
import com.osp.model.User;
import com.osp.persistence.ContractDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by tieut on 10/30/2017.
 */
public class GetContractNumberJson extends AbstractAction {
    private String id;
    private String value;

    public String execute(){
        ContractDao beanContractDao=(ContractDao) this.getBean("beanContractDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return SUCCESS;
        if(!StringUtils.isBlank(id)){
            ContractNumber item=beanContractDao.getContractNumber(id);
            if(item!=null){
                value=id+"/"+item.getValue();
            }else{
                ContractNumber itemAdd=new ContractNumber();
                itemAdd.setId(id);
                itemAdd.setValue(1);
                try{
                    itemAdd=beanContractDao.addContractNumber(itemAdd);
                    if(itemAdd!=null){
                        value=id+"/"+itemAdd.getValue();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return SUCCESS;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }
}
