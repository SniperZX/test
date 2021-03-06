package com.test.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("/")
	public String getIndex(HttpServletRequest request,HttpServletResponse response){
		
		return "index";
		
	}
	
	@RequestMapping("/detail")
	public String getDetail(HttpServletRequest request,HttpServletResponse response,Model model){
		model.addAttribute("url",request.getParameter("url"));
		return "detail";
		
	}
	

}
