package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.domain.team.Player;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamInfoController.class)
public class TeamInfoControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamInfoController teamInfoController;

    @Test
    public void shouldGetPlayers() throws Exception {
        //Given
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L, "Messi"));
        players.add(new Player(2L, "Alba"));
        players.add(new Player(3L, "Griezmann"));

        when(teamInfoController.getTeam(anyString())).thenReturn(players);

        //When&Then
        mockMvc.perform(get("/team")
                .param("name", "Barcelona")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].playerName", is("Griezmann")));
    }

    @Test
    public void shouldGetLeagues() throws Exception {
        //Given
        List<TeamInfo> teams = new ArrayList<>();
        teams.add(new TeamInfo("Barcelona"));
        teams.add(new TeamInfo("Real Madrid"));
        teams.add(new TeamInfo("Atletico"));

        when(teamInfoController.getTeamsList(anyString())).thenReturn(teams);

        //When&Then
        mockMvc.perform(get("/team/league")
                .param("name", "Primera Division")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Atletico")));
    }

    @Test
    public void shouldDeleteTeam() throws Exception {
        //Given&When&Then
        mockMvc.perform(delete("/team/delete")
                .param("id", "1"))
                .andExpect(status().isOk());

        verify(teamInfoController, times(1)).deleteTeam(anyLong());
    }
}
