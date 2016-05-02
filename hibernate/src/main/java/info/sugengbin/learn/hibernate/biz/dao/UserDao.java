/** 
 * Project Name:hibernate 
 * File Name:UserDao.java 
 * Package Name:info.sugengbin.learn.hibernate.biz.dao 
 * Date:2016年5月1日下午2:59:27 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.hibernate.biz.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.sugengbin.learn.hibernate.base.BaseEntityDao;
import info.sugengbin.learn.hibernate.biz.domain.User;

/** 
 * ClassName:UserDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年5月1日 下午2:59:27 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Repository
@Transactional
public class UserDao extends BaseEntityDao<User> implements IUserDao {

}
