package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;


@Controller
public class IndexController {
 
	private static final Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping("/index")
	public ModelAndView index()
	{
		logger.debug(logger.getName()+"In Index Controller");
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	//TODO: remove this
	@RequestMapping("/template")
	public ModelAndView template()
	{
		System.out.println("in template controller");
		ModelAndView mv = new ModelAndView("template");
		return mv;
	}
	
}
