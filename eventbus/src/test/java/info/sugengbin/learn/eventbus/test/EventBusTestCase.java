/** 
 * Project Name:eventbus 
 * File Name:EventBusTestCase.java 
 * Package Name:info.sugengbin.learn.eventbus.test 
 * Date:2016年4月16日下午3:22:11 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.eventbus.test;

import info.sugengbin.learn.eventbus.async.EventBusAsync;
import info.sugengbin.learn.eventbus.async.event.AsyncTaskEvent;
import info.sugengbin.learn.eventbus.sync.EventBusSync;
import info.sugengbin.learn.eventbus.sync.event.TaskEvent;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName:EventBusTestCase <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月16日 下午3:22:11 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:META-INF/spring/spring-config.xml")
//多个文件 @ContextConfiguration(locations ={"classpath:spring-mybatis.xml","classpath:application-context-provider.xml"})
public class EventBusTestCase {

	private final Log log = LogFactory.getLog(getClass());

	@Test
	public void testSyncEventBus() {
		log.info("\n testSyncEventBus start -- ");
		TaskEvent event = new TaskEvent().setId("123").setName("sugengbin")
				.setDate(new Date());
		EventBusSync.post(event);
		log.info("\n testSyncEventBus end -- ");
	}

	@Test
	public void testAsyncEventBus() {
		log.info("\n testAsyncEventBus start -- ");
		AsyncTaskEvent event = new AsyncTaskEvent().setId("qwe")
				.setName("sugengbin").setDate(new Date());
		EventBusAsync.post(event);
		log.info("\n testAsyncEventBus end -- ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}

}
