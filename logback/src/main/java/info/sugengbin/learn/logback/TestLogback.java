package info.sugengbin.learn.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.sugengbin.learn.common.utils.ClockUtils;

public class TestLogback {

	private static final Logger logger = LoggerFactory.getLogger(TestLogback.class);

	public static void main(String[] args) {
		ClockUtils clock = new ClockUtils("test", 0);
		for (int i = 0; i < 300000; i++) {
			logger.info("this is logtest info log: {}", i);
		}
		clock.clock("耗时：");//28948毫秒
	}
	
}
