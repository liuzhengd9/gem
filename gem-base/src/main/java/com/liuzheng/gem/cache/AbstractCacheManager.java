package com.liuzheng.gem.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractCacheManager<K, V> {

	public static final long DEFAULT_TIMEOUT = 60;

	public static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;

	public void setValue(K key, V value, long timeout, TimeUnit unit) {

		this.getRedisTemplate().opsForValue().set(getCacheKeyPrefix(key), value, timeout <= 0L ? DEFAULT_TIMEOUT : timeout, unit == null ? DEFAULT_TIMEUNIT : unit);
	}

	public V getValue(K key) {

		return this.getRedisTemplate().opsForValue().get(getCacheKeyPrefix(key));
	}

	public void deleteValue(K key) {

		this.getRedisTemplate().delete(getCacheKeyPrefix(key));
	}

	public abstract RedisTemplate<K, V> getRedisTemplate();

	public abstract K getCacheKeyPrefix(K key);

}
