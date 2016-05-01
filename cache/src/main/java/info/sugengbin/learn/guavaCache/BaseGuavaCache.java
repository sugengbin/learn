/** 
 * Project Name:cache 
 * File Name:BaseGuavaCahce.java 
 * Package Name:info.sugengbin.learn.guavaCache 
 * Date:2016年4月28日下午10:56:21 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.guavaCache;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

/**
 * ClassName:BaseGuavaCahce <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月28日 下午10:56:21 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public abstract class BaseGuavaCache<K, V> extends BaseCache<K, V> {

	private volatile Cache<K, V> guavaCache;

	public void setCache(Cache<K, V> cache) {
		this.guavaCache = cache;
	}

	public Cache<K, V> getCache() {
		return guavaCache;
	}

	protected abstract void initCache();

	// InitializingBean
	public void afterPropertiesSet() throws Exception {
		initCache();
		super.afterPropertiesSet();
	}

	protected static final int UNSET = -1;
	private long expireAfterAccess = UNSET;
	private long expireAfterWrite = UNSET;

	public long getExpireAfterAccess() {
		return expireAfterAccess;
	}

	public void setExpireAfterAccess(long expireAfterAccess) {
		this.expireAfterAccess = expireAfterAccess;
	}

	public long getExpireAfterWrite() {
		return expireAfterWrite;
	}

	public void setExpireAfterWrite(long expireAfterWrite) {
		this.expireAfterWrite = expireAfterWrite;
	}

	protected <E, F> Cache<E, F> buildCache(){
		return buildCache(null);
	}
	
	/**
	 * 创建guavaCache
	 * @param cacheLoader
	 * @return
	 */
	protected <E, F> Cache<E, F> buildCache(CacheLoader<E, F> cacheLoader) {
		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
		if (UNSET != getExpireAfterAccess()) {
			// expireAfterAccess(long, TimeUnit) 这个方法是根据某个键值对最后一次访问之后多少时间后移除
			builder.expireAfterAccess(getExpireAfterAccess(), TimeUnit.SECONDS);
		}
		if (UNSET != getExpireAfterWrite()) {
			// expireAfterWrite(long, TimeUnit) 这个方法是根据某个键值对被创建或值被替换后多少时间移除
			builder.expireAfterWrite(getExpireAfterWrite(), TimeUnit.SECONDS);
		}
		if (null == cacheLoader) {
			return builder.build();
		} else {
			return builder.build(cacheLoader);
		}
	}

	// implements ICache method

	public V get(K key) {
		return guavaCache.getIfPresent(key);
	}

	public Map<K, V> get(Collection<K> keys) {
		return guavaCache.getAllPresent(keys);
	}

	public Map<K, V> getAll() {
		return Collections.unmodifiableMap(guavaCache.asMap());
	}

	public void remove(K key) {
		guavaCache.invalidate(key);
	}

	public void remove(Collection<K> keys) {
		guavaCache.invalidateAll(keys);
	}

	public void removeAll() {
		guavaCache.invalidateAll();
	}

	public void put(K key, V value) {
		guavaCache.put(key, value);
	}

	public void put(Map<? extends K, ? extends V> map) {
		guavaCache.putAll(map);
	}

}
