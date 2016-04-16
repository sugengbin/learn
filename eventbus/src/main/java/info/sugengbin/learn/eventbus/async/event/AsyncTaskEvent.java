/** 
 * Project Name:eventbus 
 * File Name:AsyncTaskEvent.java 
 * Package Name:info.sugengbin.learn.eventbus.async.event 
 * Date:2016年4月16日下午3:39:40 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.eventbus.async.event;

import info.sugengbin.learn.eventbus.Event;

import java.util.Date;

/**
 * ClassName:AsyncTaskEvent <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年4月16日 下午3:39:40 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
public class AsyncTaskEvent implements Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3950295797081782028L;
	private String id;
	private String name;
	private Date date;

	public String getId() {
		return id;
	}

	public AsyncTaskEvent setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public AsyncTaskEvent setName(String name) {
		this.name = name;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public AsyncTaskEvent setDate(Date date) {
		this.date = date;
		return this;
	}

}
