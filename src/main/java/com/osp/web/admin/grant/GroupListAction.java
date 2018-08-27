package com.osp.web.admin.grant;

import com.osp.common.web.AbstractAction;
import com.osp.model.Group;
import com.osp.persistence.GrantDao;
import com.osp.persistence.PagingResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by tieut on 10/19/2017.
 */
public class GroupListAction extends AbstractAction {
    private Logger logger= LogManager.getLogger(GroupListAction.class);
    private PagingResult page = new PagingResult();
    private String filterName;
    private String message;

    public String execute(){
        GrantDao beanGrantDao=(GrantDao) this.getBean("beanGrantDao");
        beanGrantDao.pageGroup(page,filterName);
        if(page.getItems().size()>0){
            List<Group> items=(List<Group>)page.getItems();
            for(Group item: items){
                System.out.println(item.getId() +"--"+item.getUserCreated().getUsername()+"--"+item.getUserUpdated().getUsername());
            }
        }

        return SUCCESS;
    }

    public PagingResult getPage() {
        return page;
    }

    public void setPage(PagingResult page) {
        this.page = page;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
