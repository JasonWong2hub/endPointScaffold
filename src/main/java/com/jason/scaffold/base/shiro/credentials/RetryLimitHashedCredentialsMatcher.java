package com.jason.scaffold.base.shiro.credentials;

import com.jason.scaffold.base.shiro.cache.RedisCache;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private RedisCache<String, AtomicInteger> passwordRetryCache;

    private static final String CACHE_NAME = "passwordRetryCache:";

    /**
     * 锁定时长 （分钟）
     */
    private static final int LOCK_TIME = 5;

    /**
     * 密码重试次数
     */
    private static final Integer MAX_RETRY_COUNT = 5;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        final String loginName = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(loginName);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(loginName, retryCount);
        }
        if (retryCount.incrementAndGet() > MAX_RETRY_COUNT) {
            throw new RuntimeException("账号密码登录错误次数过多，锁定" + LOCK_TIME + "分钟!");
        } else {
            passwordRetryCache.put(loginName, retryCount, LOCK_TIME, TimeUnit.MINUTES);
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            this.passwordRetryCache.remove(loginName);
        }
        return super.doCredentialsMatch(token, info);
    }


    public void setCacheManager(CacheManager cacheManager) {
        Cache<String, AtomicInteger> cache = cacheManager.getCache(CACHE_NAME);
        this.passwordRetryCache = (RedisCache) cache;
    }
}
