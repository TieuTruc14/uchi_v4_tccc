package com.osp.security;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.osp.common.web.AbstractAction;
import com.osp.model.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by tieut on 10/31/2017.
 */
public class BasicAuthenticationInterceptor extends AbstractAction implements Interceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ValueStack stack = ActionContext.getContext().getValueStack();
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) getRequest().getUserPrincipal();
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) getRequest().getUserPrincipal();

        User user =(User)authentication.getPrincipal();
        String strBasicAuthentication =builAuthorization(user.getUsername(), user.getPassword());//"Basic c2NvdHQxMTExMTExOnRpZ2Vy";
        stack.set("BasicAuthenticationInterceptor", strBasicAuthentication);

        String result = invocation.invoke();
        return result;
    }

    private String builAuthorization(String username, String password){
        String strAut = username+":"+password;
        byte[]   bytesEncoded = Base64.encodeBase64(strAut.trim().getBytes());
        return "Basic "+new String(bytesEncoded);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }
}
