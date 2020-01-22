package com.jason.scaffold.base.shiro.realm;

import cn.hutool.core.util.StrUtil;
import com.jason.scaffold.entity.User;
import com.jason.scaffold.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class AuthRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if ((token == null || StrUtil.isBlank(token.getUsername()) || token.getPassword() == null)) {
            throw new AuthenticationException("用户名与密码不能为空!");
        } else {
            String loginUserId = (String) token.getPrincipal();
            User user = userService.getById(loginUserId);
            if (user == null) {
                throw new UnknownAccountException("账号或密码错误!");
            } else {

            }
        }
        return null;
    }


}
