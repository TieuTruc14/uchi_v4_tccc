package com.osp.web.category.manual;

import com.osp.common.web.AbstractAction;
import com.osp.model.Manual;
import com.osp.persistence.ManualDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 17/10/2017.
 */
public class ManualDetailAction extends AbstractAction{
    private Logger logger = LogManager.getLogger(ManualDetailAction.class);
    private Manual item;
    private String[] listNameFile;
    private int id;
    public String execute() throws Exception{
        ManualDao beanManualDao = (ManualDao)this.getBean("beanManualDao");
        try{
            item =beanManualDao.getManual(id);
            listNameFile =item.getFileName().split(",");
        }catch (Exception e){
            logger.error("ManualDetailAction"+e.getMessage());
        }
        return SUCCESS;
    }

    public String[] getListNameFile() {
        return listNameFile;
    }

    public void setListNameFile(String[] listNameFile) {
        this.listNameFile = listNameFile;
    }



    public Manual getItem() {
        return item;
    }

    public void setItem(Manual item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
