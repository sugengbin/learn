/** 
 * Project Name:log 
 * File Name:TestLog4j.java 
 * Package Name:info.sugengbin.learn.log4j 
 * Date:2016年4月26日下午11:04:15 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory.getLogger(TestLog4j.class);

	public static void main(String[] args) {
		ClockUtils clock = new ClockUtils("test", 0);
		for (int i = 0; i < 300000; i++) {
			logger.info("this is logtest info log: " + i);
		}
		clock.clock("耗时：");//29579毫秒
	}

	public void afterPropertiesSet() throws Exception {
//      log4j.xml文件不在根目录下的时候，需要进行加载注入test
//		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-beans.xml");
	}

}
