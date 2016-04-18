/** 
 * Project Name:eventbus 
 * File Name:TaskEventListener.java 
 * Package Name:info.sugengbin.learn.eventbus.sync.listener 
 * Date:2016年4月16日下午2:44:34 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.eventbus.sync.listener;

import info.sugengbin.learn.eventbus.EventListener;
import info.sugengbin.learn.eventbus.sync.EventBusSync;
import info.sugengbin.learn.eventbus.sync.event.TaskEvent;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.eventbus.Subscribe;

/** 
 * ClassName:TaskEventListener <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月16日 下午2:44:34 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class TaskEventListener implements EventListener {

	private final Log log = LogFactory.getLog(getClass());
	
	//@PostConstruct 在构造函数之后执行
	@PostConstruct
	public void init() {
		EventBusSync.register(this);
	}

	// guava 事件方法注解
	@Subscribe
	public boolean processEvent(TaskEvent event) {
		log.info(String.format("Process Event, id:%s,name:%s,date:%s", event.getId(), event.getName(), event.getDate()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		return Boolean.TRUE;
	}

}

