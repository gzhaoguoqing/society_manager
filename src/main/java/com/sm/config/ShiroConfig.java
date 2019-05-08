package com.sm.config;

import com.sm.filter.AuthFilter;
import com.sm.filter.FormAuthFilter;
import com.sm.filter.PermFilter;
import com.sm.shiro.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        /* 自定义filter注册 */
//        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
//        bean.setFilters(filtersMap);
//        filtersMap.put("formAuthoFilter", new FormAuthFilter());
//        filtersMap.put("authFilter", new AuthFilter());
//        filtersMap.put("permFilter", new PermFilter());

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/api/login", "anon");
        filterChainDefinitionMap.put("/api/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean
    public Realm customRealm() {
        return new CustomRealm();
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
        creator.setUsePrefix(true);
        return creator;
    }
}

