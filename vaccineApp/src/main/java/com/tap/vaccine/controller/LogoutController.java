package com.tap.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{
	
	@RequestMapping(value="/logout")
	public String goToLoginPage(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String ob=(String) (session.getAttribute("email"));
		if(session!=null) {
			System.out.println(ob);
			session.setAttribute("logoutStatus", true);
			session.invalidate();
		}else {
            return "redirect:/LoginPage";
        }
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
		
		return "/WEB-INF/Login.jsp";
	}
}
