package com.jett.tutorial.cupcakeclickerapi.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @MockBean
    private UserRepository userRepository;

    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "Boss";
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, name, 1));

        Iterable<User> iterable = users;
        Mockito.when(userRepository.findAll()).thenReturn(iterable);

        User user = userService.getUserByName(name);
        assertTrue(user.getName().equals(name));
    }

    @Test
    public void whenValidName_thenUserShouldBeCreated() {
        String name = "Boss";
    
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User(1, name, 0));

        User expectedUser = userService.createNewUser(name);
        assertTrue(expectedUser.getName().equals(name));
    }

    @Test
    public void whenValidUser_thenUserShouldBeSaved() {
        User user = new User(1, "Boss", 5);

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User expectedUser = userService.saveUserData(user);
        assertTrue(expectedUser.getName().equals(user.getName()));
    }

    @Test
    public void whenValidName_thenUserShouldBeDeleted() {
        String name = "Boss";
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, name, 1));

        Iterable<User> iterable = users;
        Mockito.when(userRepository.findAll()).thenReturn(iterable);

        User user = userService.deleteUserByName(name);
        assertTrue(user.getClicks() == -1);
    }
}