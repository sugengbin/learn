/** 
 * Project Name:eventbus 
 * File Name:AsyncTaskEventListener.java 
 * Package Name:info.sugengbin.learn.eventbus.async.listener 
 * Date:2016年4月16日下午3:48:04 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.eventbus.async.listener;

import info.sugengbin.learn.eventbus.EventListener;
import info.sugengbin.learn.eventbus.async.EventBusAsync;
import info.sugengbin.learn.eventbus.async.event.AsyncTaskEvent;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.eventbus.Subscribe;

/** 
 * ClassName:AsyncTaskEventListener <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月16日 下午3:48:04 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class AsyncTaskEventListener implements EventListener {

	private final Log log = LogFactory.getLog(getClass());
	
	//@PostConstruct 在构造函数之后执行
	@PostConstruct
	public void init() {
		EventBusAsync.register(this);
	}

	// guava 事件方法注解
	@Subscribe
	public boolean processEvent(AsyncTaskEvent event) {
		log.info(String.format("Process Event, id:%s,name:%s,date:%s", event.getId(), event.getName(), event.getDate()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		return Boolean.TRUE;
	}

}
