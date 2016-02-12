package com.web.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;

import com.web.config.SpringMongoConfig;
import com.web.model.User;

@Controller
public class UserController {
	ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
	
	
	@RequestMapping("/user")
	public ModelAndView CreateUserAndDisplay(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
	
 System.out.println("in user ccontroller");
		
		User user = new User();
		
		UserService service=new UserService(mongoOperation);

		// find the saved user again.
		User savedUser = service.findUser(name);
		
		System.out.println(savedUser.getEmail());
		
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("name", user.getName());
		return mv;
	}
	
	@RequestMapping("/register")
	public String showRegister()
	{
		System.out.println("in register method");
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user)
	{
		UserService service=new UserService(mongoOperation);
		service.createUser(user);
		return "register";
	}
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
