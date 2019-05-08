package com.sm.filter;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter extends AuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        System.out.println("111");
        return true;
    }

    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("222");
        return false;
    }
}
