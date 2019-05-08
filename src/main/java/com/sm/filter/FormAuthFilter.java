package com.sm.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class FormAuthFilter extends FormAuthenticationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        System.out.println("55");
        return true;
    }

    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("66");
        return false;
    }
}
