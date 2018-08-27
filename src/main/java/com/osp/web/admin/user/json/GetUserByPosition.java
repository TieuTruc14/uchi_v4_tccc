package com.osp.web.admin.user.json;

import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import com.osp.model.UserViewName;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/28/2017.
 */
public class GetUserByPosition extends AbstractAction {
    private String position;
    private List<UserViewName> items=new ArrayList<>();

    public String execute(){
        UserDao beanUserDao=(UserDao) this.getBean("beanUserDao");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user==null || StringUtils.isBlank(position)) return SUCCESS;
        List<User> users=beanUserDao.getUserByPosition(position);
        if(users!=null && users.size()>0){
            for(User item:users){
                items.add(new UserViewName(item.getId(),item.getFullName()));
            }
        }
        return SUCCESS;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<UserViewName> getItems() {
        return items;
    }
}
