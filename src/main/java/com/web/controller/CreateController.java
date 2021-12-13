package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.StudentDao;
import com.web.model.Student;

@Controller
public class CreateController {

	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/")
	public String createStudent(){
		return "create";
	}
	
	@RequestMapping("/temp")
	public String  temp(){
		return "temp";
	}
}
