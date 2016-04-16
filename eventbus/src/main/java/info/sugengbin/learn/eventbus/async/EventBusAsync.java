/** 
 * Project Name:eventbus 
 * File Name:EventBusAsync.java 
 * Package Name:info.sugengbin.learn.eventbus.async 
 * Date:2016年4月16日下午3:34:35 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.eventbus.async;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.AsyncEventBus;

/** 
 * ClassName:EventBusAsync <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月16日 下午3:34:35 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class EventBusAsync {

	private static final AsyncEventBus eventBusInstance = new AsyncEventBus(new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>() ));

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
