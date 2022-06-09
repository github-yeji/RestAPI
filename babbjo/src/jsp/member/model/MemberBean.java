package jsp.member.model;

import java.sql.Timestamp;

public class MemberBean {
	private String id;
	private String password;
	private String name;
	private String age;
	private String gender;
	private String birthyy;
	private String birthmm;
	private String birthdd;
	private Timestamp reg;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public String getBirthyy() {
		return birthyy;
	}
	public void setBirthyy(String birthyy) {
		this.birthyy = birthyy;
	}
	public String getBirthmm() {
		return birthmm;
	}
	public void setBirthmm(String birthmm) {
		this.birthmm = birthmm;
	}
	public String getBirthdd() {
		return birthdd;
	}
	public void setBirthdd(String birthdd) {
		this.birthdd = birthdd;
	}
	

}
