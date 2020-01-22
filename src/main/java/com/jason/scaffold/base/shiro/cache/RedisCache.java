package com.jason.scaffold.base.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisCache<K, V> implements Cache<K, V> {

    private static final String REDIS_SHIRO_CACHE_KEY_PREFIX = "redis:shiro:cache:";
    private String cacheName;
    private RedisTemplate<K, V> redisTemplate;

    public RedisCache(String cacheName, RedisTemplate<K, V> redisTemplate) {
        this.cacheName = cacheName;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) throws CacheException {
        return redisTemplate.opsForValue().get(getCacheKey(key));
    }

    @Override
    public V put(K key, V value) throws CacheException {
        redisTemplate.opsForValue().set(getCacheKey(key), value);
        return value;
    }

    public V put(K key, V value, long expire, TimeUnit timeUnit) throws CacheException {
        redisTemplate.opsForValue().set(getCacheKey(key), value, expire, timeUnit);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        K completeKey = getCacheKey(key);
        V value = redisTemplate.opsForValue().get(completeKey);
        redisTemplate.opsForValue().getOperations().delete(completeKey);
        return value;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private K getCacheKey(Object k) {
        return (K) (REDIS_SHIRO_CACHE_KEY_PREFIX + this.cacheName + k);
    }
}
