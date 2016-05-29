/** 
 * Project Name:utils 
 * File Name:Binary.java 
 * Package Name:info.sugengbin.learn.common.bitSet 
 * Date:2016年5月29日上午1:08:38 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.bitSet;

import java.util.BitSet;

/**
 * ClassName:Binary <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月29日 上午1:08:38 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class Binary {

	private BitSet bitSet;

	public Binary(BitSet bitSet) {
		this.bitSet = bitSet;
	}

	public BitSet getBitSet() {
		return this.bitSet;
	}

	public void open(IBitEnum bitEnum) {
		bitSet.set(bitEnum.index());
	}

	public void close(IBitEnum bitEnum) {
		bitSet.clear(bitEnum.index());
	}

	public boolean isOpen(IBitEnum bitEnum) {
		return bitSet.get(bitEnum.index());
	}
}
