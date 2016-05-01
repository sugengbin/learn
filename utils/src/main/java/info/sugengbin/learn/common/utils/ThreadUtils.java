/** 
 * Project Name:utils 
 * File Name:ThreadUtils.java 
 * Package Name:info.sugengbin.learn.common.utils 
 * Date:2016年4月30日下午5:41:43 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.common.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ThreadUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月30日 下午5:41:43 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class ThreadUtils {

	/** 线程池 */
	private static ExecutorService threadPool;

	private static final int minThreadPoolSize = 6;

	public static void execute(Runnable runnable) {
		getThreadPoolExecutor().execute(runnable);
	}

	public static synchronized ExecutorService getThreadPoolExecutor() {
		if (threadPool == null) {
			int threadPoolSize = Runtime.getRuntime().availableProcessors();
			if (threadPoolSize < minThreadPoolSize) {
				threadPoolSize = minThreadPoolSize;
			}
			threadPool = Executors.newFixedThreadPool(threadPoolSize);
		}

		return threadPool;
	}
}
