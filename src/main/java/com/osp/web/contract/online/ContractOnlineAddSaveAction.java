package com.osp.web.contract.online;

import com.osp.common.web.AbstractAction;
import com.osp.model.Contract;
import com.osp.model.contract.ContractJson;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by tieut on 10/26/2017.
 */
public class ContractOnlineAddSaveAction  extends AbstractAction {
    private ContractJson item;
    private File file;

    public String execute(){
        if(item!=null)
        System.out.println(item.getContractNumber());
        return SUCCESS;
    }

    public ContractJson getItem() {
        return item;
    }

    public void setItem(ContractJson item) {
        this.item = item;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
