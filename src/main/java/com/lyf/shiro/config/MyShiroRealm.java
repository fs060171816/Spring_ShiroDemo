package com.lyf.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 身份验证核心类
 * Created by Administrator on 2018/3/7.
 */
public class MyShiroRealm extends AuthorizingRealm{

    /***
     * 此方法调用hasRole,hasPermission的时候才会进行回调
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        principalCollection.getPrimaryPrincipal();
        return authenticationInfo;
    }

    /***
     * 认证信息(身份验证)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroREalm.doGetAuthenticationInfo()");

        // 获得用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());

//        需要添加密码盐值
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,"123456",getCredentialsSalt(), getName());

        // 明文，若存在，将此用户存放到登录认证info中
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,"123456", getName());

        return authenticationInfo;
    }
}
