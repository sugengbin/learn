/** 
 * Project Name:i18n 
 * File Name:MessageUtilsTestCase.java 
 * Package Name:info.sugengbin.learn.i18n.test 
 * Date:2016年5月24日下午11:39:17 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.i18n.test;

import info.sugengbin.learn.i18n.MessageUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * ClassName:MessageUtilsTestCase <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年5月24日 下午11:39:17 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:META-INF/spring/*.xml")
public class MessageUtilsTestCase {

	private @Autowired @Qualifier("messageUtils") MessageUtils messageUtils;
	
	@Test
	public void testMessage(){
		Assert.assertEquals("你们", messageUtils.getMessage("test"));
		Assert.assertEquals("你们", messageUtils.getMessage("test1", "哈哈"));
		Assert.assertEquals("哈哈", messageUtils.getMessageByDefault("test2", "哈哈"));
	}
}
