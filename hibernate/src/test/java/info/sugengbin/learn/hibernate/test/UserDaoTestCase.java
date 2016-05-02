/** 
 * Project Name:hibernate 
 * File Name:UserDaoTestCase.java 
 * Package Name:info.sugengbin.learn.hibernate.test 
 * Date:2016年5月1日下午3:51:37 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.hibernate.test;

import info.sugengbin.learn.common.utils.IdGenerateUtils;
import info.sugengbin.learn.hibernate.biz.dao.IUserDao;
import info.sugengbin.learn.hibernate.biz.domain.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName:UserDaoTestCase <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月1日 下午3:51:37 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/*.xml")
public class UserDaoTestCase {

	private @Autowired IUserDao userDao;

	@Test
	public void saveUser() {
		User user = new User();
		String id = IdGenerateUtils.generateId();
		user.setId(id).setName("sugengbin")
				.setAge("27").setPhoneNumber("15013882802").setSex("boy")
				.setAddress("China");
		userDao.save(user);
		
		User loadUser = userDao.load(id);
		Assert.assertEquals(user.getName(), loadUser.getName());
	}

}
