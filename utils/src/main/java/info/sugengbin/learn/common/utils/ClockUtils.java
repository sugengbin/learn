package info.sugengbin.learn.common.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName: ReportClock <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年4月19日 上午12:09:07 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 */
public class ClockUtils {

	private static final Logger logger = LoggerFactory.getLogger(ClockUtils.class);

	protected Date first = null;
	protected Date last = null;
	protected Date cur = null;
	/** 时间类型 -- 毫秒 **/
	public static final int TIME_TYPE_MILLISECOND = 0;
	/** 时间类型 -- 秒 **/
	public static final int TIME_TYPE_SECONDS = 1;
	/** 时间类型 -- 分钟 **/
	public static final int TIME_TYPE_MINUTES = 2;
	protected int timeType; // 时间类型
	protected String logLvl = "INFO"; // 默认log级别

	/**
	 * 默认
	 */
	public ClockUtils() {
		this("Clock start at: " + MyDateUtils.now(), TIME_TYPE_SECONDS);
	}

	/**
	 * 
	 * @param msg
	 * @param timeType
	 */
	public ClockUtils(String msg, int timeType) {
		last = MyDateUtils.now();
		cur = last;
		first = last;// 初始化第一次
		this.timeType = timeType;
		log(msg);
	}

	/**
	 * 计时方法
	 * 
	 * @param msg
	 */
	public void clock(String msg) {
		last = cur;
		cur = MyDateUtils.now();
		log(msg + ": " + getIntervalTime());
	}

	/**
	 * 计算时间间隔
	 * 
	 * @return
	 */
	protected String getIntervalTime() {
		String tmStr = "";
		switch (timeType) {
		case 0: // 毫秒
			tmStr = (cur.getTime() - last.getTime()) + "毫秒";
			break;
		case 1: // 秒
			tmStr = MyDateUtils.getDiffMillisecond(last, cur) + "秒";
			break;
		case 2: // 分钟
			tmStr = MyDateUtils.getDiffMins(last, cur) + "分钟";
			break;
		}
		return tmStr;
	}

	/**
	 * 设置log级别
	 * 
	 * @param logLvl
	 */
	public void setLogLvl(String logLvl) {
		this.logLvl = logLvl;
	}

	/**
	 * 输出日志
	 * 
	 * @param msg
	 */
	protected void log(String msg) {
		if (logLvl.equals("INFO")) {
			logger.info(msg);
		} else if (logLvl.equals("DEBUG")) {
			logger.debug(msg);
		} else if (logLvl.equals("ERROR")) {
			logger.error(msg);
		}
	}

}
