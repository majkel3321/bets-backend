package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.MatchDto;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class MatchControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchController matchController;

    @Test
    public void shouldGetMatches() throws Exception {
        //Given
        List<MatchDto> matches = new ArrayList<>();
        matches.add(new MatchDto(1L, "Barcelona", "Real Madrid", 1.7, 2.3, 2.1));
        matches.add(new MatchDto(2L, "Valencia", "Real Sociedad", 1.5, 2.1, 3.1));
        matches.add(new MatchDto(3L, "Atletico", "Real Madrid", 2.2, 2.3, 2.1));

        when(matchController.getMatches(anyString())).thenReturn(matches);

        //When&Then
        mockMvc.perform(get("/matches/all")
                .param("leagueName", "Primiera Division")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].homeTeam", is("Atletico")));
    }

    @Test
    public void shouldDeleteMatch() throws Exception {
        //Given&When&Then
        mockMvc.perform(delete("/matches/delete")
                .param("id", "1"))
                .andExpect(status().isOk());

        verify(matchController, times(1)).deleteMatch(anyLong());
    }
}
