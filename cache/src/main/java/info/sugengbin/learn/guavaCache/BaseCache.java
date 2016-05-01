/** 
 * Project Name:cache 
 * File Name:BaseCache.java 
 * Package Name:info.sugengbin.learn.guavaCache 
 * Date:2016年4月28日下午10:45:15 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.guavaCache;

import info.sugengbin.learn.guavaCache.manager.CacheManager;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * ClassName:BaseCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月28日 下午10:45:15 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public abstract class BaseCache<K, V> implements ICache<K, V>,
		InitializingBean, BeanFactoryAware {

	protected BeanFactory beanFactory;

	/**
	 * cache name
	 */
	protected String name;
	
	/**
	 * 在beanFactory中获得bean
	 * @param name
	 * @param requiredType
	 * @return
	 * @throws BeansException
	 */
	public <T> T getBean(String name, Class<T> requiredType)
			throws BeansException {
		return beanFactory.getBean(name, requiredType);
	}

	//BeanFactoryAware
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	
	// InitializingBean
	public void afterPropertiesSet() throws Exception {
		 CacheManager.getInstance().register(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
