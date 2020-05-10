package com.jett.tutorial.cupcakeclickerapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin
public class UserController {

	@RequestMapping("/{userName}")
	public User getUserByName(@PathVariable("userName") String name) {
		return new User(name, 0);
	}

}