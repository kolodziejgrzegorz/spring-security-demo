package com.luv2code.springsecurity.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping({"/","/home"})
	public String showHome() {
		return "home";
	}
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@RequestMapping("/user/userTest")
	public String showUserPage() {
		return "userTest";
	}
	@RequestMapping("/admin/adminTest")
	public String showAdminPage() {
		return "adminTest";
	}
	@RequestMapping("/user/links")
	public String showLinksPage() {
		return "links";
	}
	@RequestMapping("/user/error")
	public String showErrorPage() {
		return "access-denied";
	}
	

}
