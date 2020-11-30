package com.myorg.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myorg.model.User;
import com.myorg.service.UserService;

@Controller
public class UserController {
	 private final UserService userService;
	 
	 @Autowired
	 public UserController(UserService userService){
		 this.userService = userService;
	 }
	 
	 
	 @RequestMapping(value="/userProfile",    method=RequestMethod.GET)
	 public ModelAndView showUser(Principal principal){
		 ModelAndView modelAndView = new ModelAndView();
		 
		 
		 User user = userService.findByUsername(principal.getName()).get();
		 
		 modelAndView.addObject(user);
		 modelAndView.setViewName("/userProfile");
		 return modelAndView;
	 }
	 
}
