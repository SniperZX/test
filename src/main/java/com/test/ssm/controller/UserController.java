package com.test.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.ssm.domain.User;
import com.test.ssm.service.UserServiceImpl;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("show")
	public String showName(Model model,HttpServletRequest request){
		User user = userService.getUserById(1);
		user.setName("ll");
		model.addAttribute("user", user);
		return "show";
	}
	
}
