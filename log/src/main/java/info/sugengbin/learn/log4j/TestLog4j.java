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
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class TestLog4j implements InitializingBean {

	private static final Log log = LogFactory.getLog(TestLog4j.class);

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-beans.xml");
		for (int i = 0; i < 10000; i++) {
			log.info("this is log4j info log: " + i);
		}
	}


	public void afterPropertiesSet() throws Exception {
		
	}

}
