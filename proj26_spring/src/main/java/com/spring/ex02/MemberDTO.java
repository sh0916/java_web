package com.spring.ex02;

public class MemberDTO {

	String userID;
	String userName;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		System.out.println("setUserID 실행");
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("setUserName 실행");
		this.userName = userName;
	}
}
