package info.sugengbin.learn.common.chain.condition;

import info.sugengbin.learn.common.chain.ICheckHandler;
import info.sugengbin.learn.common.chain.test.ReqDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: CheckUser <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:07:44 <br/> 
 * 
 * @author sugengbin 
 * @version  
 * @since JDK 1.7
 */
@Component
public class CheckUser implements ICheckHandler<ReqDto> {

	static List<String> userList = new ArrayList<String>();
	static {
		userList.add("user1");
		userList.add("user2");
		userList.add("user3");
		userList.add("user4");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String user = req.getUser();
			if (userList.contains(user)) {
				pass = true;
			}
		} catch (Exception e) {
		}
		return pass;
	}

}
