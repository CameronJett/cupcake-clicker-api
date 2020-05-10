package com.jett.tutorial.cupcakeclickerapi.Controller;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class UserController {

	@GetMapping("/{userName}")
	public User getUserByName(@PathVariable("userName") String name) {
		return new User(name, 0);
	}

	@PostMapping("")
	public User createNewUser(@RequestBody String name) {
		return new User(name, 0);
	}
}