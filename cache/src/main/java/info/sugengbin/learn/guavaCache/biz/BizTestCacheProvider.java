/** 
 * Project Name:cache 
 * File Name:BizTestCacheProvider.java 
 * Package Name:info.sugengbin.learn.guavaCache.biz 
 * Date:2016年4月30日下午5:58:52 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.guavaCache.biz;

import java.util.Map;

import info.sugengbin.learn.guavaCache.provider.IFullLoadCacheProvider;

/** 
 * ClassName:BizTestCacheProvider <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月30日 下午5:58:52 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class BizTestCacheProvider<K, V> implements IFullLoadCacheProvider<K, V> {

	@Override
	public Map<? extends K, ? extends V> reload() {
		// TODO Auto-generated method stub
		return null;
	}

}
