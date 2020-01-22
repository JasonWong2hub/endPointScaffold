package com.jason.scaffold.base.shiro.config;

import com.jason.scaffold.base.shiro.cache.RedisCacheManager;
import com.jason.scaffold.base.shiro.credentials.RetryLimitHashedCredentialsMatcher;
import com.jason.scaffold.base.shiro.realm.AuthRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ShiroAutoConfiguration {

    @Bean
    public SecurityManager securityManager(AuthRealm realm, CacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        List<Realm> realms = new ArrayList();
        realms.add(realm);
        securityManager.setRealms(realms);
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }

    @Bean
    public AuthRealm realm(CredentialsMatcher credentialsMatcher) {
        AuthRealm realm = new AuthRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    @Bean
    public CacheManager cacheManager() {
        CacheManager cacheManager = new RedisCacheManager();
        return cacheManager;
    }

    @Bean
    public CredentialsMatcher credentialsMatcher(CacheManager cacheManager) {
        RetryLimitHashedCredentialsMatcher matcher = new RetryLimitHashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5"); // 加密方式
        matcher.setHashIterations(2); // 加密次数
        matcher.setStoredCredentialsHexEncoded(true);// 存储散列后的密码是否为16进制
        matcher.setCacheManager(cacheManager);
        return matcher;
    }

}
