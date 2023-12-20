package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.RegisterService;

@Controller
public class RegisterController {
	
	private RegisterService registerservice;
	
	@Autowired
	public RegisterController(RegisterService registerservice) {
		this.registerservice = registerservice;
	}
	@RequestMapping(value="/RegisterPage")
	public String enterRegisterPage(Model model) {
		System.out.println("enter into register page");
		return "/WEB-INF/Register.jsp";
	}
	
	@RequestMapping(value="/LoginPage1")
	public String enterLoginPage(Model model) {
		System.out.println("enter into Login page");
		return "/WEB-INF/Login.jsp";
	}
	
	@RequestMapping(value="/saveData")
	public String saveRegisterEntity(@RequestParam String username,@RequestParam String email,@RequestParam String password,@RequestParam long mobileNumber,@RequestParam String gender,@RequestParam String dob,Model model) {
		System.out.println("savedata");
		boolean isValid=registerservice.isValidData(username,email,password,mobileNumber,gender,dob);
		if(isValid) {
			boolean isSaved=registerservice.saveRegisterEntity(username,email,password,mobileNumber,gender,dob);
			if(isSaved) {
				model.addAttribute("responsemessage1","Data is valid && saved");	
			}else {
				model.addAttribute("responsemessage1","something went wrong..try again");
			}
		}else {
			model.addAttribute("responsemessage1","Data is Not-valid try again...Enter valid data");
		}
		return "/WEB-INF/Register.jsp";
	}
}
