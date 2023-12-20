package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.LoginDAO;
import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginService {
	
	private LoginDAO logindao;
	
	private JavaMailSenderImpl javamailsender;
	
	@Autowired
	public LoginService(LoginDAO logindao,JavaMailSenderImpl javamailsender) {
		this.logindao = logindao;
		this.javamailsender=javamailsender;
	}
	public boolean validData(String email, String password) {
		boolean flag=false;
		if(email!=null && !email.isBlank() && !email.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		if(password!=null && !password.isBlank() && !password.isEmpty()) {
			flag=true;
		}else {
			return false;
		}
		return flag;
	}
	public boolean verifyLoginCredentials(String email, String password) {
		RegisterEntity entity = logindao.getRegisterEntityByEmail(email);
		if(entity.getLoginAttempt()>=3)
		{
			SimpleMailMessage simplemailmessage=new SimpleMailMessage();
			simplemailmessage.setTo(email);
			simplemailmessage.setSubject("Vaccine Application");
			simplemailmessage.setText("account is Blocked Due to Too Many Attempts.please reset the password & login again");
			javamailsender.send(simplemailmessage);
			return false;
		}
		else if(entity.getEmail().equals(email) && entity.getPassword().equals(password)) {
			return true;
		}else {
			int loginAttempt=entity.getLoginAttempt();
			int i=logindao.updateLoginAttempt(email,loginAttempt);
			return false;
		}
	}
	public RegisterEntity getEntityByEmail(String email) {
		RegisterEntity entity = logindao.getRegisterEntityByEmail(email);
		return entity;
	}


}
