package com.jett.tutorial.cupcakeclickerapi.Service;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByName(String name) {
        return new User(name, 23);
    }

    @Override
    public User createNewUser(String name) {
        return new User(name, 0);
    }

    @Override
    public User saveUserData(User user) {
        return user;
    }
    
}