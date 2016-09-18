package com.xiaozai.test.controller.param;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="user item", description="user object")
public class User {

	@ApiModelProperty(value="this id of user item", required=true)
	private String userId;
	@ApiModelProperty(value="user name", notes="username")
	private String userName;
	@ApiModelProperty(value="user sex", notes="0 man, 1 felman")
	private int sex;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
}
