package com.tap.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.dao.ForgotPasswordDAO;

@Component
public class ForgotPasswordService {
	
	private JavaMailSenderImpl javamailsender;
	private ForgotPasswordDAO forgotpassworddao;
	
	@Autowired
	public ForgotPasswordService(JavaMailSenderImpl javamailsender, ForgotPasswordDAO forgotpassworddao) {
		this.javamailsender = javamailsender;
		this.forgotpassworddao = forgotpassworddao;
	}

	public boolean validData(String email, String newpassword, String confirmnewpassword) {
		boolean flag=false;
		if(email!=null && !email.isBlank() && !email.isEmpty()) {
			flag=true;
		}
		else {
			return false;
		}
		if(newpassword!=null && !newpassword.isBlank() && !newpassword.isEmpty()) {
			flag=true;
		}
		else {
			return false;
		}
		if(confirmnewpassword!=null && !confirmnewpassword.isBlank() && !confirmnewpassword.isEmpty()) {
			flag=true;
		}
		else {
			return false;
		}
		return flag;
	}

	public boolean resetPasswordByEmail(String email, String newpassword) {
		boolean isDone=forgotpassworddao.resetPasswordByEmail(email,newpassword);
		if(isDone) {
			SimpleMailMessage simplemailmessage=new SimpleMailMessage();
			simplemailmessage.setTo(email);
			simplemailmessage.setSubject("Vaccine Application");
			simplemailmessage.setText("You have successfull reset the password "+newpassword+" for "+email);
			javamailsender.send(simplemailmessage);
			return true;
		}else {
			return false;
		}
	}

}
