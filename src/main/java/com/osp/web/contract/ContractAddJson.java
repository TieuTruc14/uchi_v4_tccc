package com.osp.web.contract;

import com.osp.common.web.AbstractAction;
import com.osp.model.contract.ContractJson;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by tieut on 10/31/2017.
 */
public class ContractAddJson extends AbstractAction {
    private static final long serialVersionUID = -7691332912528571416L;
    private String item;
    private boolean message=false;
    public String execute(){
//        JSONParser parser = new JSONParser();
//        String jsondata = JSONConfigure.getAngularJSONFile();
//        if(item!=null){
//            System.out.println("Gia tri that su la khac roi: "+ item.getContractNumber());
//        }
        System.out.println(item);
        return SUCCESS;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isMessage() {
        return message;
    }

}
