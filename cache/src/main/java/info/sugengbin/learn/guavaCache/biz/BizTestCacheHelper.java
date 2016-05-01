/** 
 * Project Name:cache 
 * File Name:BizTestCacheHelper.java 
 * Package Name:info.sugengbin.learn.guavaCache.biz 
 * Date:2016年4月30日下午5:59:14 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.guavaCache.biz;

import info.sugengbin.learn.guavaCache.ICache;

/** 
 * ClassName:BizTestCacheHelper <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月30日 下午5:59:14 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class BizTestCacheHelper {
	
	private ICache<String, BizConfig> cache;
	
	public BizConfig get(String key){
		return cache.get(key);
	}
	
}
