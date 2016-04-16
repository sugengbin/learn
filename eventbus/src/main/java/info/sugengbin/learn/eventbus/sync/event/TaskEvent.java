/** 
 * Project Name:eventbus 
 * File Name:TaskEvent.java 
 * Package Name:info.sugengbin.learn.eventbus.sync.event 
 * Date:2016年4月16日下午2:47:04 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
*/ 
package info.sugengbin.learn.eventbus.sync.event;

import info.sugengbin.learn.eventbus.Event;

import java.util.Date;

/** 
 * ClassName:TaskEvent <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年4月16日 下午2:47:04 <br/> 
 * @author   sugengbin 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class TaskEvent implements Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989401646178774176L;
	private String id;
	private String name;
	private Date date;

	public String getId() {
		return id;
	}

	public TaskEvent setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public TaskEvent setName(String name) {
		this.name = name;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public TaskEvent setDate(Date date) {
		this.date = date;
		return this;
	}

}
