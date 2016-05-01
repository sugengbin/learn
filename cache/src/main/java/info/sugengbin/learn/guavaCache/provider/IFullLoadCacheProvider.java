/** 
 * Project Name:cache 
 * File Name:IFullLoadCacheProvider.java 
 * Package Name:info.sugengbin.learn.guavaCache.provider 
 * Date:2016年4月28日下午11:42:16 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.guavaCache.provider;

import java.util.Map;

/**
 * ClassName:IFullLoadCacheProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月28日 下午11:42:16 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public interface IFullLoadCacheProvider<K, V> {

	/**
	 * 一次性加载所有需要存入缓存的对象Map
	 * 
	 * @return 要存入缓存的对象Map
	 */
	Map<? extends K, ? extends V> reload();
}