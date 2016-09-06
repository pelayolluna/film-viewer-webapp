package com.pelayolluna.filmviewerservice.controllerTEST;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {

	@RequestMapping(value="/test0", method=RequestMethod.GET)
	public String test0(ModelMap model, HttpServletRequest request) {
            return "test";
	}
        
        @RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1(ModelMap model, HttpServletRequest request) {
            return "test1";
	}
}
