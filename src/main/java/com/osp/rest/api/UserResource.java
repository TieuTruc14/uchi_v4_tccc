package com.osp.rest.api;

import com.osp.common.utils.AbstractBean;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import com.osp.rest.JSendResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 9/12/2017.
 */
@Consumes("application/json")
@Produces("application/json")
@Path("/user")
public class UserResource extends AbstractBean {
    @GET
    @Path("/")
    public Response list() throws Exception {
        UserDao beanUserDao = (UserDao) this.getBean("beanUserDao");
        JSendResponse jSendResponse = new JSendResponse();
        List<User> items=beanUserDao.listUser();
        if(items!=null && items.size()>0){
            List<User> list=new ArrayList<>();
            for(User item:items){
                User user=genInfo(item);
                list.add(user);
            }
            jSendResponse.setData(list);
        }

        return Response.status(Response.Status.OK).entity(jSendResponse).build();
    }
    private User genInfo(User item){
        User user=new User();
        user.setUsername(item.getUsername());
        user.setFirstName(item.getFirstName());
        user.setLastName(item.getLastName());
        user.setPhone(item.getPhone());
        user.setEmail(item.getEmail());
        User userUpdate=new User();
        userUpdate.setId(item.getUserUpdated().getId());
        userUpdate.setFirstName(item.getUserUpdated().getFirstName());
        userUpdate.setLastName(item.getUserUpdated().getLastName());
        user.setUserUpdated(userUpdate);
        User create=new User();
        create.setId(item.getUserCreated().getId());
        create.setFirstName(item.getUserCreated().getFirstName());
        create.setLastName(item.getUserCreated().getLastName());
        user.setUserCreated(create);

        return user;
    }
}
