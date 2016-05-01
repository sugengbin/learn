/** 
 * Project Name:cache 
 * File Name:ICache.java 
 * Package Name:info.sugengbin.learn.guavaCache 
 * Date:2016年4月28日下午10:29:52 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.guavaCache;

import java.util.Collection;
import java.util.Map;

/** 
 * ClassName:ICache <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月28日 下午10:29:52 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface ICache<K, V> {
	
	/**
     * 获取缓存注册名称
     * @return 缓存注册名称
     */
    String getName();
	
	V get(K key);
	
	Map<K, V> get(Collection<K> keys);
	
	Map<K, V> getAll();
	
	void remove(K key);
	
	void remove(Collection<K> keys);
	
	void removeAll();
	
	void put(K key, V value);
	
	void put(Map<? extends K, ? extends V> map);
	
	
}
