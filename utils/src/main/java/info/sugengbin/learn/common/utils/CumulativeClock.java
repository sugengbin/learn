package info.sugengbin.learn.common.utils;

import java.math.BigDecimal;

/**
 * 
 * ClassName: CumulativeClock <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年4月19日 上午12:08:59 <br/> 
 * 
 * @author sugengbin 
 * @version  
 * @since JDK 1.7
 */
public class CumulativeClock extends ClockUtils {

	private String outputStr;

	public CumulativeClock() {
		super();
	}

	public CumulativeClock(String msg, int timeType) {
		super(msg, timeType);
	}

	public void cumulate(String msg) {
		this.cumulate(msg, false);
	}

	/**
	 * 累加计时记录，isEnd = true 时输出总记录
	 * 
	 * @param msg
	 * @param isEnd
	 */
	public void cumulate(String msg, boolean isEnd) {
		last = cur;
		cur = MyDateUtils.now();
		outputStr += msg + ": " + getIntervalTime();
		if (isEnd) {
			log(outputStr);
			outputStr = "";
		}
	}

	/**
	 * 获得开始到结束的总时间
	 * 
	 * @return
	 */
	public BigDecimal getWholeInterval() {
		return MyDateUtils.getDiffMillisecond(first, cur);
	}
}
