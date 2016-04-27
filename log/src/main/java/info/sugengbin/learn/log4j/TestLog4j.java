/** 
 * Project Name:log 
 * File Name:TestLog4j.java 
 * Package Name:info.sugengbin.learn.log4j 
 * Date:2016年4月26日下午11:04:15 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import info.sugengbin.learn.common.utils.ClockUtils;

/**
 * ClassName:TestLog4j <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月26日 下午11:04:15 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestLog4j {

	private static final Log log = LogFactory.getLog(TestLog4j.class);

	public static void main(String[] args) {
		ClockUtils clock = new ClockUtils("test", 0);
		for (int i = 0; i < 100000; i++) {
			log.info("this is log4j info log: " + i);
		}
		clock.clock("耗时：");
	}

	public void afterPropertiesSet() throws Exception {
//      log4j.xml文件不在根目录下的时候，需要进行加载注入
//		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-beans.xml");
	}

}
