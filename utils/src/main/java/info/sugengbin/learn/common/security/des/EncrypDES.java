/** 
 * Project Name:utils 
 * File Name:EncrypDES.java 
 * Package Name:info.sugengbin.learn.common.security.des 
 * Date:2016年5月29日下午3:55:11 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.security.des;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * ClassName:EncrypDES <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月29日 下午3:55:11 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class EncrypDES {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String content = "DESTest";
		// 密码长度必须是8的倍数
		String password = generateDESKey();
		System.out.println("密　钥：" + password);
		System.out.println("加密前：" + content);
		byte[] result = encrypt(content, password);
		System.out.println("加密后：" + new String(result));
		String decryResult = decrypt(result, password);
		System.out.println("解密后：" + decryResult);
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String generateDESKey() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		return new String(key.getEncoded(), "UTF-8");
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            待加密内容
	 * @param key
	 *            加密的密钥
	 * @return
	 */
	public static byte[] encrypt(String content, String key) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			byte[] result = cipher.doFinal(content.getBytes());
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param key
	 *            解密的密钥
	 * @return
	 */
	public static String decrypt(byte[] content, String key) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			byte[] result = cipher.doFinal(content);
			return new String(result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
