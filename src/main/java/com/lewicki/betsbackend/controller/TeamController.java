package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.client.ApiFootballClient;
import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.domain.team.Player;
import com.lewicki.betsbackend.service.TeamInfoService;
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

    @Autowired
    private TeamInfoService teamInfoService;

    @GetMapping
    public List<Player> getTeam(@RequestParam String name){
        name = name.replaceAll("%20"," ");
        return apiFootballClient.getTeamSquad(name);
    }

    @GetMapping("league")
    public List<TeamInfo> getTeamsList(@RequestParam String name){
        name = name.replaceAll("%20"," ");
        List<TeamInfo> teams = apiFootballClient.getLeagueInfo(name);
        teamInfoService.saveTeams(teams);
        return teams;
    }
}
