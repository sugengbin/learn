/** 
 * Project Name:utils 
 * File Name:BitEnum.java 
 * Package Name:info.sugengbin.learn.common.bitSet 
 * Date:2016年5月29日上午1:08:50 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.bitSet;

/**
 * ClassName:BitEnum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月29日 上午1:08:50 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public enum BitEnum implements IBitEnum {

	TEST0(0), TEST1(1), TEST2(2), TEST3(3);

	int idx;

	private BitEnum(int idx) {
		this.idx = idx;
	}

	@Override
	public int index() {
		return this.idx;
	}

}
