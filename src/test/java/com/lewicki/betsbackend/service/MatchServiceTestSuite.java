package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.MatchDto;
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
public class MatchServiceTestSuite {

    @Autowired
    private MatchService matchService;

    @Test
    public void testSaveMatches(){
        //Given
        List<MatchDto> matches = new ArrayList<>();
        matches.add(new MatchDto("Barcelona","Real Madrid",1.9,2.2,2.1));
        matches.add(new MatchDto("Valencia","Real Sociedad",1.91,2.21,2.11));
        matches.add(new MatchDto("Athletic","Malaga",1.92,2.22,2.12));

        //When
        matchService.saveMatches(matches);
        List<MatchDto> receivedMatches = matchService.getMatches();
        //Then
        assertEquals(3,matchService.getMatches().size());
        assertEquals("Malaga",matchService.getMatches().get(2).getAwayTeam());

        //CleanUp
        matchService.deleteMatch(receivedMatches.get(0).getId());
        matchService.deleteMatch(receivedMatches.get(1).getId());
        matchService.deleteMatch(receivedMatches.get(2).getId());
    }

    @Test
    public void testGetMatches(){
        //Given
        List<MatchDto> matches = new ArrayList<>();
        matches.add(new MatchDto("Barcelona","Real Madrid",1.9,2.2,2.1));
        matches.add(new MatchDto("Valencia","Real Sociedad",1.91,2.21,2.11));
        matches.add(new MatchDto("Athletic","Malaga",1.92,2.22,2.12));
        matchService.saveMatches(matches);

        //When
        List<MatchDto> receivedMatches = matchService.getMatches();

        //Then
        assertEquals(3,receivedMatches.size());
        assertEquals("Valencia",receivedMatches.get(1).getHomeTeam());

        //CleanUp
        matchService.deleteMatch(receivedMatches.get(0).getId());
        matchService.deleteMatch(receivedMatches.get(1).getId());
        matchService.deleteMatch(receivedMatches.get(2).getId());
    }

    @Test
    public void testDeleteMatch(){
        //Given
        List<MatchDto> matches = new ArrayList<>();
        matches.add(new MatchDto("Barcelona","Real Madrid",1.9,2.2,2.1));
        matches.add(new MatchDto("Valencia","Real Sociedad",1.91,2.21,2.11));
        matches.add(new MatchDto("Athletic","Malaga",1.92,2.22,2.12));
        matchService.saveMatches(matches);
        List<MatchDto> receivedMatches = matchService.getMatches();

        //When
        matchService.deleteMatch(receivedMatches.get(0).getId());

        //Then
        assertEquals(3,receivedMatches.size());
        assertEquals(2,matchService.getMatches().size());

        //CleanUp
        matchService.deleteMatch(receivedMatches.get(1).getId());
        matchService.deleteMatch(receivedMatches.get(2).getId());
    }
}
