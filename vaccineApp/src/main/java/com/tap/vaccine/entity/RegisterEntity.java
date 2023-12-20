package com.tap.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register_table")
public class RegisterEntity {

	@Column(name = "ID")
	@Id
	private int id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "MOBILE_NO")
	private long mobileNo;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "LOGIN_ATTEMPT")
	private int loginAttempt;
	
	@Column(name="MEMBER_COUNT")
	private int memberCount;


	public RegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterEntity(int id, String username, String email, String password, long mobileNo, String gender,
			String dob, int loginAttempt,int memberCount) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.loginAttempt = loginAttempt;
		this.memberCount=memberCount;
	}

	public RegisterEntity(int id, String username, String email, String password, long mobileNo, String gender,
			String dob) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
	}

	public RegisterEntity(String username, String email, String password, long mobileNo, String gender, String dob) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}
	
	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
	
	
	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + "]";
	}

}
