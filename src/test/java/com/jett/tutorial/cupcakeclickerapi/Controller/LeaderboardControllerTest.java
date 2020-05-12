package com.jett.tutorial.cupcakeclickerapi.Controller;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Service.LeaderboardService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class LeaderboardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    LeaderboardService leaderboardService;

	@Test
	public void shouldReturnNameOnGetRequest() throws Exception {
        User user = new User(1, "Boss", 1);
        List<User> users = new ArrayList<User>();
        users.add(user);

        Mockito.when(leaderboardService.getLeaderboardList()).thenReturn(users);

		mockMvc.perform(get("/leaderboard")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Boss")));
    }
}