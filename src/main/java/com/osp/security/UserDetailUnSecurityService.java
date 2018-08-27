package com.osp.security;

import com.osp.common.utils.AbstractBean;
import com.osp.model.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by tieut on 10/31/2017.
 */
public class UserDetailUnSecurityService extends AbstractBean implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UchiUserDetailsService beanUchiUserDetailsService = (UchiUserDetailsService) this.getBean("beanUchiUserDetailsService");
        User user=beanUchiUserDetailsService.loadUserByUsername(name);

        System.out.println("Name = " + name + " ,Password = " + password);
        String strBasicAuthentication =builAuthorization(name,password);//"Basic fgrNvdHQxMTExMTExOnRpZ2Vy";

        if(user!=null && user.getPassword().equals(password)){
            Authentication auth=new UsernamePasswordAuthenticationToken(name,password,user.getAuthorities());
            return new UsernamePasswordAuthenticationToken(name,password,user.getAuthorities());
        }

        // use the credentials and authenticate against the third-party system
//        if(("admin".equals(name) && "1".equals(password))){
//            System.out.println("Succesful authentication!");
//            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
//        }

//        System.out.println("Login fail!");

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private String builAuthorization(String username, String password){
        String strAut = username+":"+password;
        byte[]   bytesEncoded = Base64.encodeBase64(strAut.trim().getBytes());
        return "Basic "+new String(bytesEncoded);
    }
}
