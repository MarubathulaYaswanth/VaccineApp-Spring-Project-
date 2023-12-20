package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.entity.RegisterEntity;
import com.tap.vaccine.service.LoginService;

@Controller
public class LoginController {
	
	private LoginService loginservice;
	
	@Autowired
	public LoginController(LoginService loginservice) 
	{
		this.loginservice = loginservice;
	}
	
	@RequestMapping(value="/LoginPage")
	public String goToLoginPage(Model model) {
		return "/WEB-INF/Login.jsp";
	}
	
	
	@RequestMapping(value="/goToHome")
	public String checkCredentials(@RequestParam String email,@RequestParam String password,Model model,HttpServletRequest request) {
		boolean isValid=loginservice.validData(email,password);
		if(isValid) {
			boolean isLogin=loginservice.verifyLoginCredentials(email,password);
			RegisterEntity entity=loginservice.getEntityByEmail(email);
			if(isLogin) {
				model.addAttribute("loginresponsemessage",email);
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				session.setAttribute("membercount",entity.getMemberCount());
				return "/WEB-INF/Home.jsp";
			}else if(entity.getLoginAttempt()>=3) {
				model.addAttribute("loginresponsemessage","Your account is blocked and you have to reset the password to unblock your account");
			}else{
				model.addAttribute("loginresponsemessage","Login Failed:Email and password do not match you have only "+(3-entity.getLoginAttempt())+" attempts");
			}
		}else {
			model.addAttribute("loginresponsemessage","Data is not valid...try again");
		}
		return "/WEB-INF/Login.jsp";
	}
	
}
