package com.lyf.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/7.
 */
@Configuration
public class ShiroConfiguration {

    /***
     * 处理资源拦截问题
     * 注入的参数需要另外配置
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("shiroConfiguration shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String,String> filterChainDefaintionMap = new LinkedHashMap<>();

        // 具体退出代码Shiro已经实现
        filterChainDefaintionMap.put("/logout","logout");

        // 防止登陆成功之后下载favicon.ico
        filterChainDefaintionMap.put("/favicon.ico","anon");
        filterChainDefaintionMap.put("/static/**","anon");

        // 过滤链定义，从上向下顺序执行，一般将/**放在最下面
        // authc:所有url必须认证过才能访问；anon：所有url都可以匿名访问
        filterChainDefaintionMap.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        // 设置过滤Map
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefaintionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /***
     * 身份认证realm
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }
}
