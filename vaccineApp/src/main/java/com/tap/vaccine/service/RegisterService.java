package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.RegisterDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterService {
	
	private RegisterDAO registerdao;
	

	@Autowired
	public RegisterService(RegisterDAO registerdao) {
		this.registerdao = registerdao;
	}

	public boolean isValidData(String username, String email, String password, long mobileNumber, String gender,
			String dob) {
		boolean flag=false;
		if(username!=null && !username.isBlank() && !username.isEmpty()) {
			flag=true;
			System.out.println("username is valid");
		}else {
			return false;
		}
		if(email!=null && !email.isBlank() && !email.isEmpty()) {
			flag=true;
			System.out.println("email is valid");
		}else {
			return false;
		}
		if(password!=null && !password.isBlank() && !password.isEmpty()) {
			flag=true;
			System.out.println("password is valid");
		}else {
			return false;
		}
		if(gender!=null && !gender.isBlank() && !gender.isEmpty()) {
			flag=true;
			System.out.println("gender is valid");
		}else {
			return false;
		}
		if(dob!=null && !dob.isBlank() && !dob.isEmpty()) {
			flag=true;
			System.out.println("dob is valid");
		}else {
			return false;
		}
		return flag;
	}
	public boolean saveRegisterEntity(String username, String email, String password, long mobileNumber, String gender,
			String dob) {
		RegisterEntity entity=new RegisterEntity(username,email,password,mobileNumber,gender,dob);
		return registerdao.saveRegisterEntity(entity);
	}

	
	
	
	
}
