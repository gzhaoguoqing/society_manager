package com.sm.filter;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class PermFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o){
        System.out.println("222");
        return true;
    }

    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("333");
        return false;
    }
}
