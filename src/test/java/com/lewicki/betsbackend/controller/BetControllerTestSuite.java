package com.lewicki.betsbackend.controller;

import com.google.gson.Gson;
import com.lewicki.betsbackend.domain.Bet;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BetController.class)
public class BetControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BetController betController;

    @Test
    public void shouldCreateBet() throws Exception {
        //Given
        Bet bet1 = new Bet(1L, 1L, "Barcelona", "Real Madrid", "v1", 1.8, 100);
        Bet bet2 = new Bet(2L, 2L, "Barcelona", "Real Madrid", "v1", 1.8, 100);
        Bet bet3 = new Bet(3L, 3L, "Barcelona", "Real Madrid", "v1", 1.8, 100);

        Gson gson = new Gson();
        List<String> betJson = new ArrayList<>();
        betJson.add(gson.toJson(bet1));
        betJson.add(gson.toJson(bet2));
        betJson.add(gson.toJson(bet3));

        //When&Then
        for (String bet : betJson) {
            mockMvc.perform(post("/bet/create")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .characterEncoding("UTF-8")
                    .content(bet))
                    .andExpect(status().isOk());
        }

        verify(betController, times(3)).createBet(any(Bet.class));
    }

    @Test
    public void shouldGetAllBets() throws Exception {
        //Given
        List<Bet> bets = new ArrayList<>();
        bets.add(new Bet(1L, 1L, "Barcelona", "Real Madrid", "v1", 1.8, 100));
        bets.add(new Bet(2L, 2L, "Atletico", "Betis", "v1", 1.8, 100));
        bets.add(new Bet(3L, 3L, "Numancia", "Valencia", "v1", 1.8, 100));

        when(betController.getBets()).thenReturn(bets);

        //When&Then
        mockMvc.perform(get("/bet/all")
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[1].homeTeam", is("Atletico")));
    }

    @Test
    public void shouldDeleteBet() throws Exception {
        //Given
        Bet bet1 = new Bet(1L, 2L, "Barcelona", "Real Madrid", "v1", 1.8, 100);
        Gson gson = new Gson();
        String bet1Json = gson.toJson(bet1);

        mockMvc.perform(post("/bet/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(bet1Json))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/bet/delete")
                .param("id", "1"))
                .andExpect(status().isOk());


        verify(betController, times(1)).deleteBet(anyLong());
    }
}
