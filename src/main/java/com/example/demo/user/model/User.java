package com.example.demo.user.model;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class User {
	private Integer user_seq;//회원관리번호
	private String user_nm;//회원이름
	private String user_email;//회원아이디
	private String user_pwd;
	private String user_sex;//회원성별
	private Integer user_age;//회원나이
	

	@Override
	public String toString() {
		return "User [user_seq=" + user_seq + ", user_nm=" + user_nm + ", user_email=" + user_email + ", user_pwd="
				+ user_pwd + ", user_sex=" + user_sex + ", user_age=" + user_age + "]";
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public Integer getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(Integer user_seq) {
		this.user_seq = user_seq;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public Integer getUser_age() {
		return user_age;
	}
	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}
	
}