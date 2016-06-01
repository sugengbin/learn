package info.sugengbin.learn.common.chain.condition;

import info.sugengbin.learn.common.chain.ICheckHandler;
import info.sugengbin.learn.common.chain.test.ReqDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: CheckVersion <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:08:02 <br/> 
 * 
 * @author sugengbin 
 * @version  
 * @since JDK 1.7
 */
@Component
public class CheckVersion implements ICheckHandler<ReqDto> {

	static List<String> versionList = new ArrayList<String>();
	static {
		versionList.add("1.0");
		versionList.add("2.0");
		versionList.add("3.0");
		versionList.add("4.0");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String version = req.getVersion();
			if (versionList.contains(version)) {
				pass = true;
			}
		} catch (Exception e) {
		}
		return pass;
	}

}
