package info.sugengbin.learn.common.test.chain;

import info.sugengbin.learn.common.chain.CheckChain;
import info.sugengbin.learn.common.chain.test.ReqDto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * ClassName: CheckTest <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:10:37 <br/> 
 * 
 * @author sugengbin 
 * @version  
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/*.xml")
public class CheckTest {

	private @Autowired @Qualifier("checkChain") CheckChain<ReqDto> checkChain;

	@Test
	public void testCheck() {
		ReqDto req = new ReqDto().setDevice("device1").setUser("user1").setVersion("1.0");
		// if (checkChain.check(req)) {
		// System.out.println("do something ...");
		// } else {
		// System.out.println("not pass");
		// }
		Assert.assertTrue(checkChain.check(req));
		req.setDevice("device5");
		Assert.assertFalse(checkChain.check(req));
		req.setDevice("device1").setUser("user5");
		Assert.assertFalse(checkChain.check(req));
		req.setVersion("5.0");
		Assert.assertFalse(checkChain.check(req));
		req.setVersion("2.0").setUser("user2");
		Assert.assertTrue(checkChain.check(req));
	}
}
