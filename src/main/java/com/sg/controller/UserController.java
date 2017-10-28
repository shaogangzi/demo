package com.sg.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sg.bean.User;
import com.sg.service.SystemService;

@Controller
@RequestMapping("/user")
public class UserController {
   
	private  static final Logger logger=Logger.getLogger(UserController.class);
	
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String test(HttpServletRequest request,Model model){
	         String username=request.getParameter("username");
	         String pwd = request.getParameter("pwd");
	         User user=new User();
	         user.setUsername(username);
	         user.setPwd(pwd);
	         user.setSex("男");
	         user.setDepartment("开发");
	         user.setAge(18);
	         boolean register = systemService.register(user);
	         if(register){
	        	 
	        	 return "success";
	         }
	         return "loginerror";       
	}
}
