/** 
 * Project Name:utils 
 * File Name:BitSetTestCase.java 
 * Package Name:info.sugengbin.learn.common.test.bitSet 
 * Date:2016年5月29日上午1:22:44 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.common.test.bitSet;

import info.sugengbin.learn.common.bitSet.Binary;
import info.sugengbin.learn.common.bitSet.BitEnum;

import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

/** 
 * ClassName:BitSetTestCase <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年5月29日 上午1:22:44 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class BitSetTestCase {

	@Test
	public void testBitSet(){
		BitSet bitSet = new BitSet();
		Binary binary = new Binary(bitSet);
		
		// open
		binary.open(BitEnum.TEST0);
		Assert.assertTrue(binary.getBitSet().get(0));
		
		// close 
		binary.open(BitEnum.TEST2);
		Assert.assertTrue(binary.getBitSet().get(2));
		binary.close(BitEnum.TEST2);
		Assert.assertFalse(binary.getBitSet().get(2));
		
		
		// isOpen
		binary.open(BitEnum.TEST3);
		Assert.assertTrue(binary.isOpen(BitEnum.TEST3));
	}
	
}
