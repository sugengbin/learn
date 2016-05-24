/** 
 * Project Name:utils 
 * File Name:HashUtils.java 
 * Package Name:info.sugengbin.learn.common.security.md5 
 * Date:2016年5月12日上午12:10:45 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.security.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

/**
 * ClassName:HashUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月12日 上午12:10:45 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class HashUtils {

	/**
	 * @param source
	 *            需要加密的字符串
	 * @param hashType
	 *            加密类型 （MD5 和 SHA）
	 * @return
	 */
	public static String getHash2(String source, String hashType) {
		String result = StringUtils.EMPTY;
		StringBuilder sb = new StringBuilder();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance(hashType);
			md5.update(source.getBytes());
			for (byte b : md5.digest()) {
				sb.append(String.format("%02X", b)); // TODO
				// 10进制转16进制，X
				// 表示以十六进制形式输出，02
				// 表示不足两位前面补0输出
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
