/** 
 * Project Name:eventbus 
 * File Name:EventBusSync.java 
 * Package Name:info.sugengbin.learn.eventbus.sync 
 * Date:2016年4月16日下午12:42:41 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.eventbus.sync;

import com.google.common.eventbus.EventBus;

/** 
 * ClassName:EventBusSync <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月16日 下午12:42:41 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class EventBusSync {
	private static final EventBus eventBusInstance = new EventBus();

	public static void post(Object event) {
		eventBusInstance.post(event);
	}

	public static void register(Object handler) {
		eventBusInstance.register(handler);
	}

	public static void unregister(Object handler) {
		eventBusInstance.unregister(handler);
	}
}
