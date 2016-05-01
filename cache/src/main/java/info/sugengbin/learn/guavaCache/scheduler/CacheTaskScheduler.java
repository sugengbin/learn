/** 
 * Project Name:cache 
 * File Name:CacheTaskScheduler.java 
 * Package Name:info.sugengbin.learn.guavaCache.scheduler 
 * Date:2016年4月30日下午4:57:39 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.guavaCache.scheduler;
/** 
 * ClassName:CacheTaskScheduler <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月30日 下午4:57:39 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public abstract class CacheTaskScheduler implements Runnable {

	 private SCHEDULE_MODEL model;
	
	 private static enum SCHEDULE_MODEL{
		 INTERVAL
	 }
	
	 private long intervalMillis = -1L;
	 private long lastRunTimeMillis = -1L;
	/**
	 * 时间间隔模式
	 * @param refreshInterval
	 */
	public CacheTaskScheduler(int refreshInterval) {
		intervalMillis = refreshInterval * 1000;
		model = SCHEDULE_MODEL.INTERVAL;
	}

	public boolean isTimeForSchedule(long timeMillis) {
		switch(model){
		case INTERVAL:
			return isTimeForScheduleInterval(timeMillis);
		//other model
		default:
			return false;
		}
	}

	/**
	 * 是否到时间执行任务
	 * @param timeMillis
	 * @return
	 */
	private boolean isTimeForScheduleInterval(long timeMillis) {
		if(intervalMillis == -1){
			return false;
		}else if(timeMillis - lastRunTimeMillis > intervalMillis){
			lastRunTimeMillis = timeMillis;
			return true;
		}
		return false;
	}

}
