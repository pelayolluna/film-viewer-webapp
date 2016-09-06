package com.pelayolluna.filmviewerservice.controllerTEST;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pelayolluna.filmviewerservice.domainTEST.User;
import com.pelayolluna.filmviewerservice.domainTEST.UserList;
import com.pelayolluna.filmviewerservice.serviceTEST.UserService;

@Controller
public class UserController {

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	private @ResponseBody UserList getPersons() {
		
		UserList result = new UserList();
		
		result.setData(userService.getAll());
		
		return result;
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	private @ResponseBody User getPerson(@PathVariable("id") Long id) {
		return userService.get(id);
	}
}
