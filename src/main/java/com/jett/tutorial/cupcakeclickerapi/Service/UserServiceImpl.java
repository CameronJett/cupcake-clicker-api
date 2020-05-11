package com.jett.tutorial.cupcakeclickerapi.Service;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        for (User user : userRepository.findAll()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User createNewUser(String name) {
        User user = new User();
        user.setName(name);
        user.setClicks(0);

        userRepository.save(user);
        return user;
    }

    @Override
    public User saveUserData(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUserByName(String name) {
        for (User user : userRepository.findAll()) {
            if (user.getName().equals(name)) {
                userRepository.delete(user);
            }
        }
        return new User(1, name, -1);
    }
    
}