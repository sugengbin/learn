/** 
 * Project Name:hibernate 
 * File Name:User.java 
 * Package Name:info.sugengbin.learn.hibernate.biz.domain 
 * Date:2016年5月1日下午2:55:56 
 * Copyright (c) 2016, 515474146@qq.com All Rights Reserved. 
 * 
 */
package info.sugengbin.learn.hibernate.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年5月1日 下午2:55:56 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 * @see
 */
@Entity
@Table(name = "t_user")
public class User {

	/**
	 * id
	 */
	@Id
	@Column(name = "id")
	private String id;

	/**
	 * 姓名
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 年龄
	 */
	@Column(name = "age")
	private String age;

	/**
	 * 手机号码
	 */
	@Column(name = "phone_number")
	private String phoneNumber;

	/**
	 * 性别
	 */
	@Column(name = "sex")
	private String sex;

	/**
	 * 住址
	 */
	@Column(name = "address")
	private String address;

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getAge() {
		return age;
	}

	public User setAge(String age) {
		this.age = age;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public User setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public User setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

}
