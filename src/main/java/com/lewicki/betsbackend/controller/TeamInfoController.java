package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.client.ApiFootballClient;
import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.domain.team.Player;
import com.lewicki.betsbackend.service.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamInfoController {

    @Autowired
    private ApiFootballClient apiFootballClient;

    @Autowired
    private TeamInfoService teamInfoService;

    @GetMapping
    public List<Player> getTeam(@RequestParam("name") String name){
        name = name.replaceAll("%20"," ");
        return apiFootballClient.getTeamSquad(name);
    }

    @GetMapping("league")
    public List<TeamInfo> getTeamsList(@RequestParam("name") String name){
        name = name.replaceAll("%20"," ");
        List<TeamInfo> teams = apiFootballClient.getLeagueInfo(name);
        teamInfoService.saveTeams(teams);
        return teams;
    }

    @DeleteMapping("delete")
    public void deleteTeam(@RequestParam("id") Long id){
        teamInfoService.deleteTeam(id);
    }
}
