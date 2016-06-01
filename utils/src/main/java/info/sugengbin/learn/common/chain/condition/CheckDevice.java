package info.sugengbin.learn.common.chain.condition;

import info.sugengbin.learn.common.chain.ICheckHandler;
import info.sugengbin.learn.common.chain.test.ReqDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: CheckDevice <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:07:52 <br/> 
 * 
 * @author sugengbin 
 * @version  
 * @since JDK 1.7
 */
@Component
public class CheckDevice implements ICheckHandler<ReqDto> {

	static List<String> deviceList = new ArrayList<String>();
	static {
		deviceList.add("device1");
		deviceList.add("device2");
		deviceList.add("device3");
		deviceList.add("device4");
	}

	@Override
	public boolean isOpen(ReqDto req) {
		return true;
	}

	@Override
	public boolean doCheck(ReqDto req) {
		boolean pass = false;
		try {
			String device = req.getDevice();
			if (deviceList.contains(device)) {
				pass = true;
			}
		} catch (Exception e) {
		}
		return pass;
	}

}
