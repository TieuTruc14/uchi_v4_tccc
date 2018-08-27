package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.persistence.ManualDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 17/10/2017.
 */
public class ManualEditAction extends AbstractAction{
    private Logger logger= LogManager.getLogger(ManualEditAction.class);
    private int id;
    private Manual item;
    private String[] listNameFile;
    public String execute() throws Exception{
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");
        try{
            item = beanManualDao.getManual(id);

            listNameFile =item.getFileName().split(",");
        }catch (Exception e){
            logger.error("ManualEditAction"+e.getMessage());
        }
        return SUCCESS;
    }

    public String[] getListNameFile() {
        return listNameFile;
    }

    public void setListNameFile(String[] listNameFile) {
        this.listNameFile = listNameFile;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manual getItem() {
        return item;
    }

    public void setItem(Manual item) {
        this.item = item;
    }
}
