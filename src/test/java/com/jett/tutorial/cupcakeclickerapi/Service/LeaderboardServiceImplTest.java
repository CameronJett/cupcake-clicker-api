package com.jett.tutorial.cupcakeclickerapi.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
public class LeaderboardServiceImplTest {

    @TestConfiguration
    static class LeaderboardServiceImplTestContextConfiguration {

        @Bean
        public LeaderboardService leaderboardService() {
            return new LeaderboardServiceImpl();
        }
    }

    @Autowired
    private LeaderboardService leaderboardService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void whenUsersInDB_thenUserListShouldBeReturned() {
        String name = "Boss";
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, name, 1));

        Iterable<User> iterable = users;
        Mockito.when(userRepository.findAll()).thenReturn(iterable);

        List<User> userList = leaderboardService.getLeaderboardList();
        assertTrue(userList.contains(users.get(0)));
    }
    
}