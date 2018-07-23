package com.sound.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sound.model.ResponseMessageM;

@Controller
@RequestMapping(path = "/batteries")
public class BatteriesController {
	
	@GetMapping(path = "/index")
	public ModelAndView accountIndex() {
		ModelAndView mav = new ModelAndView("batteries/index");
		return mav;
	}
	
	@PostMapping(path = "/fileload")
	public ResponseMessageM dealWithBatteriesInfo(HttpServletRequest request)
	{
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 MultipartFile file = multipartRequest.getFile("excelfile");
		 
		return null;
		
	}
}
