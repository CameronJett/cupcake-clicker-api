package com.jett.tutorial.cupcakeclickerapi.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jett.tutorial.cupcakeclickerapi.Model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;
    
    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "Boss";
        User user = userService.getUserByName(name);

        assertTrue(user.getName().equals(name));
    }
    
    @Test
    public void whenValidName_thenUserShouldBeCreated() {
        String name = "Boss";
        User user = userService.createNewUser(name);

        assertTrue(user.getName().equals(name));
    }

    @Test
    public void whenValidUser_thenUserShouldBeSaved() {
        User testUser = new User("Boss", 1);
        User user = userService.saveUserData(testUser);

        assertTrue(user.equals(testUser));
    }

    @Test
    public void whenValidName_thenUserShouldBeDeleted() {
        String name = "Boss";
        User response = userService.deleteUserByName(name);

        assertTrue(response.getName().equals("Boss"));
    }
}