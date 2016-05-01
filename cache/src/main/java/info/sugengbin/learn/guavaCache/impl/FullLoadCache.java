/** 
 * Project Name:cache 
 * File Name:FullLoadCache.java 
 * Package Name:info.sugengbin.learn.guavaCache.impl 
 * Date:2016年4月28日下午11:38:32 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.guavaCache.impl;

import info.sugengbin.learn.guavaCache.BaseGuavaCache;
import info.sugengbin.learn.guavaCache.provider.IFullLoadCacheProvider;
import info.sugengbin.learn.guavaCache.scheduler.CacheTaskScheduler;
import info.sugengbin.learn.guavaCache.scheduler.ITaskSchedulerCache;

import java.util.Map;

import com.google.common.cache.Cache;

/**
 * ClassName:FullLoadCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月28日 下午11:38:32 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class FullLoadCache<K, V> extends BaseGuavaCache<K, V> implements
		ITaskSchedulerCache {

	protected IFullLoadCacheProvider<K, V> cacheProvider;

	/**
	 * 重新加载的时间间隔
	 */
	private int refreshInterval = UNSET;

	/**
	 * init时候加载一次
	 */
	private boolean initLoad = true;

	/**
	 * 调度任务
	 */
	private CacheTaskScheduler cacheTaskScheduler;
	
	public int getRefreshInterval() {
		return refreshInterval;
	}

	public void setRefreshInterval(int refreshInterval) {
		this.refreshInterval = refreshInterval;
	}

	public CacheTaskScheduler getCacheTaskScheduler() {
		return cacheTaskScheduler;
	}

	public void setCacheTaskScheduler(CacheTaskScheduler cacheTaskScheduler) {
		this.cacheTaskScheduler = cacheTaskScheduler;
	}

	@Override
	protected void initCache() {
		Cache<K, V> cache = buildCache();
		super.setCache(cache);
		if (initLoad) {
			refreshCache(false);
		}
		this.cacheTaskScheduler = createTaskScheduler();
	}

	private CacheTaskScheduler createTaskScheduler() {
		if(refreshInterval != UNSET) {
			return new CacheTaskScheduler(refreshInterval){
				public void run(){
					refreshCache(true);
				}
			};
		}
		return null;
	}

	/**
	 * <pre>
	 * 刷新cache
	 * if clear = true ,重新建立cache
	 * if clear = false ,从provider中加载数据到cache
	 * 
	 * <pre>
	 * @param clear
	 */
	private void refreshCache(boolean clear) {
		if (null != cacheProvider) {
			Map<? extends K, ? extends V> map = cacheProvider.reload();
			if (null == map) {
				map = java.util.Collections.emptyMap();
			}
			if (clear) {
				Cache<K, V> cache = buildCache();
				cache.putAll(map);
				super.setCache(cache);
			} else {
				put(map);
			}
		}
	}

}
