/** 
 * Project Name:utils 
 * File Name:IdGenerateUtils.java 
 * Package Name:info.sugengbin.learn.common.utils 
 * Date:2016年5月1日下午4:04:54 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.utils;

import java.util.UUID;

/**
 * ClassName:IdGenerateUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月1日 下午4:04:54 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class IdGenerateUtils {

	public static String generateId() {
		String s = UUID.randomUUID().toString();
		// 去掉"-"符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}
}
