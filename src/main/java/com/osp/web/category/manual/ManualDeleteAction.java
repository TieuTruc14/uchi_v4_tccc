package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.persistence.ManualDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 19/10/2017.
 */
public class ManualDeleteAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ManualDeleteAction.class);
    private int id;
    private String message;


    public String execute() throws Exception{
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");
        try{
            Manual itemGet = beanManualDao.getManual(id);
            beanManualDao.deleteManual(itemGet);
            message = "xóa thành công ";

        }catch (Exception e){
            logger.error("ManualDeleteAction"+e.getMessage());
        }
        return SUCCESS;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
