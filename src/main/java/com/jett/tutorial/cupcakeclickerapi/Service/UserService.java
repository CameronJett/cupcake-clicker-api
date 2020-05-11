package com.jett.tutorial.cupcakeclickerapi.Service;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

public interface UserService {
    public User getUserByName(String name);
    public User createNewUser(String name);
	public User saveUserData(User user);
}