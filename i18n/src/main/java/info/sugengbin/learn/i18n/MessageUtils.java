/** 
 * Project Name:i18n 
 * File Name:MessageUtils.java 
 * Package Name:info.sugengbin.learn.i18n 
 * Date:2016年5月24日下午11:28:51 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.i18n;

import info.sugengbin.learn.common.utils.MyStringUtils;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * ClassName:MessageUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月24日 下午11:28:51 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class MessageUtils {

	private MessageSource messageSource;
	private Locale locale;

	/**
	 * 获取国际化配置
	 * 
	 * @param key
	 * @param args
	 * @return
	 */
	public String getMessage(String key, String... args) {
		String message = MyStringUtils.EMPTY;
		try {
			message = messageSource.getMessage(key, args, locale);
		} catch (Exception e) {
		}
		return message;
	}

	/**
	 * 获取国际化配置 有默认值
	 * 
	 * @param key
	 * @param defaultMessage
	 * @param args
	 * @return
	 */
	public String getMessageByDefault(String key, String defaultMessage, String... args) {
		String message = MyStringUtils.EMPTY;
		try {
			message = messageSource.getMessage(key, args, defaultMessage,
					locale);
		} catch (Exception e) {
		}
		return message;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
