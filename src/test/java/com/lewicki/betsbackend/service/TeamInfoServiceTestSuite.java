package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamInfoServiceTestSuite {

    @Autowired
    private TeamInfoService teamInfoService;

    private List<TeamInfo> teams;

    @Before
    public void createAndSaveTeams(){
        teams = new ArrayList<>();
        teams.add(new TeamInfo(1L,"Barcelona"));
        teams.add(new TeamInfo(2L,"Real Madrid"));
        teams.add(new TeamInfo(3L,"Atletico"));
        teamInfoService.saveTeams(teams);
    }

    @After
    public void cleanUp(){
        teamInfoService.deleteTeam(teams.get(0).getTeam_id());
        teamInfoService.deleteTeam(teams.get(1).getTeam_id());
        teamInfoService.deleteTeam(teams.get(2).getTeam_id());
    }

    @Test
    public void testSaveTeams(){
        //Given&When&Then
        assertEquals(3,teamInfoService.getTeams().size());
    }

    @Test
    public void testGetTeams(){
        //Given&When
        List<TeamInfo> receivedTeams = teamInfoService.getTeams();

        //Then
        assertEquals(3,receivedTeams.size());
        assertEquals("Atletico",receivedTeams.get(2).getName());
    }

    @Test
    public void testGetTeam(){
        //Given&When
        TeamInfo receivedTeamInfo = teamInfoService.getTeam("Atletico");

        //Then
        assertEquals("Atletico",receivedTeamInfo.getName());
        assertEquals(3L,receivedTeamInfo.getTeam_id().longValue());
    }

    @Test
    public void testDeleteTeam(){
        //Given
        List<TeamInfo> teamInfos = new ArrayList<>();
        teamInfos.add(new TeamInfo(4L,"Valencia"));
        teamInfoService.saveTeams(teamInfos);

        List<TeamInfo> receivedTeams = teamInfoService.getTeams();

        //When
        teamInfoService.deleteTeam(4L);

        //Then
        assertEquals(4,receivedTeams.size());
        assertEquals(3,teamInfoService.getTeams().size());
    }
}
