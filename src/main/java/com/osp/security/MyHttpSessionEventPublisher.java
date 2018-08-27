package com.osp.security;

import com.osp.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.http.HttpSessionEvent;

/**
 * Created by tieut on 11/2/2017.
 */
public class MyHttpSessionEventPublisher extends HttpSessionEventPublisher {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        super.sessionCreated(event);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        if(event.getSession().getAttribute("username")!=null && event.getSession().getAttribute("username").toString().length()>0){
            System.out.println("Ban ay da ra di:"+event.getSession().getAttribute("username")+"--"+event.getSession().getId());
        }

        //do something
        super.sessionDestroyed(event);
    }
}
