package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 17/10/2017.
 */
public class ManualAddAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ManualAddAction.class);
    private Manual item;


    public String execute() throws Exception{

        return SUCCESS;
    }



    public Manual getItem() {
        return item;
    }

    public void setItem(Manual item) {
        this.item = item;
    }
}
