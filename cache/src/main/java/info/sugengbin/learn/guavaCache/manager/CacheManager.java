/** 
 * Project Name:cache 
 * File Name:CacheManager.java 
 * Package Name:info.sugengbin.learn.guavaCache.manager 
 * Date:2016年4月30日下午4:49:35 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.guavaCache.manager;

import info.sugengbin.learn.common.utils.ThreadUtils;
import info.sugengbin.learn.guavaCache.ICache;
import info.sugengbin.learn.guavaCache.scheduler.CacheTaskScheduler;
import info.sugengbin.learn.guavaCache.scheduler.ITaskSchedulerCache;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName:CacheManager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月30日 下午4:49:35 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class CacheManager {

	private static CacheManager instance = new CacheManager();

	public static CacheManager getInstance() {
		return instance;
	}

	private Map<String, ICache<?, ?>> caches = new ConcurrentHashMap<>();// 1.8特性

	private Map<String, CacheTaskScheduler> cacheTaskSchedulers = new ConcurrentHashMap<>();

	private static Thread scheduleThread = null;

	private static long scheduleInterval = 10 * 1000L;

	public <K, V> void register(ICache<K, V> cache) {
		if (cache instanceof ITaskSchedulerCache) {
			CacheTaskScheduler scheduler = ((ITaskSchedulerCache) cache)
					.getCacheTaskScheduler();
			if (null != scheduler) {
				cacheTaskSchedulers.put(cache.getName(), scheduler);
				startScheduleThread();
			}
		}
		caches.put(cache.getName(), cache);
	}

	private synchronized void startScheduleThread() {
		if (!cacheTaskSchedulers.isEmpty() && null == scheduleThread) {
			scheduleThread = new ScheduleThread();
			scheduleThread.start();
		}
	}

	public class ScheduleThread extends Thread {
		public ScheduleThread() {
			super("CacheTaskScheduleThread");
			super.setDaemon(true);
		}

		public void run() {
			while (true) {
				// schedule all tasks
				try {
					doRun();
				} catch (Exception x) {

				} finally {
					try {
						Thread.sleep(scheduleInterval);
					} catch (InterruptedException e) {
					}
				}
			}
		}

		public void doRun() {
			long timeMillis = System.currentTimeMillis();
			Iterator<Map.Entry<String, CacheTaskScheduler>> it = cacheTaskSchedulers
					.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, CacheTaskScheduler> entry = it.next();
				CacheTaskScheduler scheduler = entry.getValue();
				try {
					if (scheduler.isTimeForSchedule(timeMillis)) {
						ThreadUtils.execute(scheduler);
					}
				} catch (Exception e) {

				}
			}
		}
	}

}
