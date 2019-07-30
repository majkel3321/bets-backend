package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    @Test
    public void shouldGetUsers() throws Exception {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("walter1", "walter1", "walte1@email.com"));
        users.add(new User("walter2", "walter2", "walte2@email.com"));
        users.add(new User("walter3", "walter3", "walte3@email.com"));

        when(userController.getAllUsers()).thenReturn(users);

        //When&Then
        mockMvc.perform(get("/user/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[1].username",is("walter2")));
    }

    @Test
    public void shouldGetUser() throws Exception {
        //Given
        User user = new User("Walter","Walter1","walter@email.com");
        when(userController.getUser(anyLong())).thenReturn(user);

        //When&Then
        mockMvc.perform(get("/user")
        .param("id","1")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",is("Walter")));
    }



}
