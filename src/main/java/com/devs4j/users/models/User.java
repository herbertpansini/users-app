package com.devs4j.users.models;

public class User {

	public User() {
	}
	
	public User(String nickName, String userName, String password) {
		this.nickName = nickName;
		this.userName = userName;
		this.password = password;
	}
	
	private String nickName;
	private String userName;
	private String password;
	
	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
