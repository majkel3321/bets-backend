package com.lewicki.betsbackend.client;

import com.lewicki.betsbackend.domain.league.League;
import com.lewicki.betsbackend.domain.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ApiFootballClient {

    @Autowired
    private RestTemplate restTemplate;

    private final HashMap<String, Long> teams;

    public ApiFootballClient() {
        teams = new HashMap<>();
        teams.put("PremierLeague",2L);
        teams.put("PrimeraDivision",30L);
        teams.put("SerieA",28L);
        teams.put("Ligue1",4L);
        teams.put("Bundesliga1",8L);
        teams.put("Ekstraklasa",517L);
        teams.put("ChampionsLeague",31L);
        teams.put("SuperLeague",82L);
    }

    public Team getTeamSquad(){
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HttpHeaderInterceptor("X-RapidAPI-Key","b4f84b21dbmsha822435a0352086p182f03jsn10487ebe1034"));
        interceptors.add(new HttpHeaderInterceptor("Accept","application/json"));

        restTemplate.setInterceptors(interceptors);
        Team team = restTemplate.getForObject("https://api-football-v1.p.rapidapi.com/v2/players/squad/529/2018-2019",
                Team.class);

        return team;
    }

    public League getLeagueInfo(String name){
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HttpHeaderInterceptor("X-RapidAPI-Key","b4f84b21dbmsha822435a0352086p182f03jsn10487ebe1034"));
        interceptors.add(new HttpHeaderInterceptor("Accept","application/json"));

        restTemplate.setInterceptors(interceptors);
        League league = restTemplate.getForObject("https://api-football-v1.p.rapidapi.com/v2/teams/league/" + teams.get(name),
                League.class);

        return league;
    }
}
