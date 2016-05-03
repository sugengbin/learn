package info.sugengbin.learn.common.security.base64;

import java.util.Base64;

public class Base64Utils {

	/**
	 * BASE64编码
	 * 
	 * since jdk1.8
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] input) throws Exception {
		return Base64.getEncoder().encodeToString(input);
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String input) throws Exception {
		return Base64.getEncoder().encodeToString(input.getBytes("utf-8"));
	}
	
	/**
	 * BASE64解码
	 * 
	 * since jdk1.8
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String input) throws Exception {
		return Base64.getDecoder().decode(input);
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64String(String input) throws Exception {
		byte[] decrypt = Base64.getDecoder().decode(input);
		return new String(decrypt, "utf-8");
	}
}
