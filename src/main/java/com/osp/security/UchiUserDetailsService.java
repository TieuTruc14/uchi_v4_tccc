package com.osp.security;

import com.osp.common.utils.AbstractBean;
import com.osp.model.User;
import com.osp.persistence.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

/**
 * Created by tieut on 9/11/2017.
 */
public class UchiUserDetailsService extends AbstractBean implements UserDetailsService{
    public static final String ROLE_USER = "ROLE_USER";

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException{
        UserDao beanUserDao=(UserDao)this.getBean("beanUserDao");
        User user=null;

        user=beanUserDao.getUserByUsername("admin");

        if (user != null) {
            List<GrantedAuthority> lstAuths = new ArrayList<GrantedAuthority>();
            lstAuths.add(new SimpleGrantedAuthority(ROLE_USER));

            user.setGrantedAuths(lstAuths);
        }else{
            throw new UsernameNotFoundException("No user found for username '" + username +"'.");
        }

        return user;
    }

}
