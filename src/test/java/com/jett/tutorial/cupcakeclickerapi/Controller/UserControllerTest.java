package com.jett.tutorial.cupcakeclickerapi.Controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jett.tutorial.cupcakeclickerapi.Model.User;
import com.jett.tutorial.cupcakeclickerapi.Service.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @MockBean
    UserService userService;

	@Test
	public void shouldReturnNameOnGetRequest() throws Exception {
        Mockito.when(userService.getUserByName(Mockito.anyString())).thenReturn(new User("Boss", 0));

		mockMvc.perform(get("/Boss")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Boss")));
    }
    
	@Test
	public void shouldReturnUserOnPostRequest() throws Exception {
        Mockito.when(userService.createNewUser(Mockito.anyString())).thenReturn(new User("Boss", 0));

        mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
            .content("{\"Boss\"}"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Boss")));
	}
}