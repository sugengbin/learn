/*
* Copyright 2015-2020 SF-Express Tech Company. 
*/
package info.sugengbin.learn.common.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串二进制标识位接口，实现default公共方法 <br/>
 * Date: 2016年5月20日 <br/>
 * 
 * @author 449632
 */
public interface IBinaryEnum {

	final String DEFAULT_INPUT = "0";

	/**
	 * 打开标记位 <br/>
	 * open(11100,2) -> 11100 | 00010 -> 11110
	 * 
	 * @param iden
	 *            二进制标识
	 * @param index
	 *            从右到左坐标，1开始
	 * @return 最新二进制标识
	 */
	default String open(String iden, int index) {
		int output = 0;
		try {
			if (StringUtils.isBlank(iden)) {
				iden = DEFAULT_INPUT;
			}
			output = Integer.valueOf(iden) | (0x1 << (index - 1));
		} catch (NumberFormatException e) {

		}
		return Integer.toBinaryString(output);
	}

	/**
	 * 关闭标记位<br/>
	 * close(11100,3) -> 11100 & 11011 -> 11011
	 * 
	 * @param iden
	 *            二进制标识
	 * @param index
	 *            从右到左坐标，1开始
	 * @return 最新二进制标识
	 */
	default String close(String iden, int index) {
		int output = 0;
		try {
			if (StringUtils.isBlank(iden)) {
				iden = DEFAULT_INPUT;
			}
			output = Integer.valueOf(iden) & ~(0x1 << (index - 1));
		} catch (NumberFormatException e) {
		}
		return Integer.toBinaryString(output);
	}

	/**
	 * 标记为是否打开状态<br/>
	 * isOpen(1010, 2) -> 1010 & 0010 == 0010 -> true
	 * 
	 * @param iden
	 *            二进制标识
	 * @param index
	 *            从右到左坐标，1开始
	 * @return true/false
	 */
	default boolean isOpen(String iden, int index) {
		boolean result = false;
		try {
			if (StringUtils.isBlank(iden)) {
				iden = DEFAULT_INPUT;
			}
			int oper = (0x1 << (index - 1));
			result = ((Integer.valueOf(iden, 2) & oper) == oper);
		} catch (NumberFormatException e) {
		}
		return result;
	}

}
