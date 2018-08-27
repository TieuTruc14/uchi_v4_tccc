package com.osp.web.category.template.contractTemplate.json;

import com.osp.common.web.AbstractAction;
import com.osp.model.ContractTemplate;
import com.osp.model.User;
import com.osp.model.contract.ContractTemplateJson;
import com.osp.persistence.ContractTemplateDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/28/2017.
 */
public class ContractTemplateListJson extends AbstractAction {
    private String kindId;
    private List<ContractTemplateJson> items=new ArrayList<>();
    public String execute(){
        ContractTemplateDao beanContractTemplateDao=(ContractTemplateDao) this.getBean("beanContractTemplateDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null) return SUCCESS;
        List<ContractTemplate> list=new ArrayList<>();
        if(StringUtils.isBlank(kindId)){
            list=beanContractTemplateDao.listEnable();
        }else{
            list=beanContractTemplateDao.listEnableByKindId(kindId);
        }
        if(list.size()>0){
            for(ContractTemplate item:list){
                items.add(genFromTemplate(item));
            }
        }

        return SUCCESS;
    }

    public List<ContractTemplateJson> getItems() {
        return items;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId;
    }

    private ContractTemplateJson genFromTemplate(ContractTemplate item){
        ContractTemplateJson json=new ContractTemplateJson();
        json.setId(item.getId().toString());
        json.setName(item.getName());
        json.setContractKind(item.getContractKind().getId().toString());
        json.setPeriodStatus(item.isPeriodStatus());
        json.setMortageCancel(item.isMortageCancel());
        json.setContent(item.getContent());
        return json;
    }
}
