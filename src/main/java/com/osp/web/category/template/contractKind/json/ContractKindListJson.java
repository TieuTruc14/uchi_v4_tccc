package com.osp.web.category.template.contractKind.json;

import com.osp.common.web.AbstractAction;
import com.osp.model.ContractKind;
import com.osp.model.User;
import com.osp.model.contract.ContractKindJson;
import com.osp.persistence.ContractKindDao;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/28/2017.
 */
public class ContractKindListJson extends AbstractAction {
    private List<ContractKindJson> items=new ArrayList<>();

    public String execute(){
        ContractKindDao beanContractKindDao=(ContractKindDao) this.getBean("beanContractKindDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return SUCCESS;
        List<ContractKind> list=beanContractKindDao.listEnable();
        if(list!=null && list.size()>0){
            for(ContractKind item:list){
                items.add(genFromContractKind(item));
            }
        }
        return SUCCESS;
    }

    public List<ContractKindJson> getItems() {
        return items;
    }


    private ContractKindJson genFromContractKind(ContractKind item){
        ContractKindJson json=new ContractKindJson();
        json.setId(item.getId().toString());
        json.setName(item.getName());
        return json;
    }
}
