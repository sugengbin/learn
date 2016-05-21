/*
* Copyright 2015-2020 SF-Express Tech Company. 
*/
package info.sugengbin.learn.common.enums;

/**
 * C端快件变更类型 <br/>
 * Date: 2016年5月20日 <br/>
 * 
 * @author 449632
 */
public enum DemoType implements IBinaryEnum {

	/**
	 * 派送时间
	 */
	DELIVERY_TM(1),

	/**
	 * 派送方式
	 */
	DELIVERY_WAY(2),

	/**
	 * 设置代收人
	 */
	AGENT(3),

	/**
	 * 联系方式
	 */
	CONTACT(4),
	
	/**
	 * 取消代收人
	 */
	CANCEL_AGENT(5);

	int digit;

	private DemoType(int digit) {
		this.digit = digit;
	}

	/**
	 * 该类型是否变更
	 * 
	 * @param iden
	 * @return
	 */
	public boolean isChange(String iden) {
		return isOpen(iden, this.digit);
	}

	/**
	 * 打开该枚举类型标识位
	 * 
	 * @param iden
	 * @return
	 */
	public String open(String iden) {
		return open(iden, this.digit);
	}

	/**
	 * 关闭该枚举类型标识位
	 * 
	 * @param iden
	 * @return
	 */
	public String close(String iden) {
		return close(iden, this.digit);
	}
}
