package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.client.ApiFootballClient;
import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.domain.team.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private ApiFootballClient apiFootballClient;

    @GetMapping
    public List<Player> getTeam(){
        return apiFootballClient.getTeamSquad().getApi().getPlayers();   //usunac teamDto i playersDto - wystarczy przeslac dane tak jak tu
                                                                            //i po prostu odczytac te ktore sa potrzebne przy pomocy @JsonIgnoreUnknown po stronie frontendu
    }

    @GetMapping("leagueInfo")
    public List<TeamInfo> getTeamInfo(@RequestParam String name){
        return apiFootballClient.getLeagueInfo(name).getApi().getTeams();
    }
}
