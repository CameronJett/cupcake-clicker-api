package com.jett.tutorial.cupcakeclickerapi.Controller;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Service.UserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{userName}")
	public User getUserByName(@PathVariable("userName") String name) {
		return userService.getUserByName(name);
	}

	@PostMapping("")
	public User createNewUser(@RequestBody String name) {
		return userService.createNewUser(name);
	}

	@PostMapping("/save")
	public User saveUserData(@RequestBody User user) {
		return userService.saveUserData(user);
	}

}