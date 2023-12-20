package com.tap.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccine.service.ForgotPasswordService;

@Controller
public class ForgotPasswordController {
	
	private ForgotPasswordService service;
	
	@Autowired
	public ForgotPasswordController(ForgotPasswordService service) {
		this.service = service;
	}

	@RequestMapping(value="/goToForgotPasswordPage")
	public String goToForgotPasswordPage() {
		return "/WEB-INF/ForgotPassword.jsp";
	}
	
	@RequestMapping(value="/goToIndexPage")
	public String goToIndexPage() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/forgotpassword")
	public String forgotPassword(@RequestParam String email,@RequestParam String newpassword,@RequestParam String confirmnewpassword,Model model) {
		boolean isValid=service.validData(email,newpassword,confirmnewpassword);
		if(isValid) {
			boolean isUpdated=service.resetPasswordByEmail(email,newpassword);
			if(isUpdated) {
				model.addAttribute("successresopnse","Password changed successfully");
				return "/WEB-INF/Login.jsp";
			}else {
				model.addAttribute("forgotpasswordrespoonse","something went wrong");
			}
		}
		return "/WEB-INF/ForgotPassword.jsp";
	}
}
