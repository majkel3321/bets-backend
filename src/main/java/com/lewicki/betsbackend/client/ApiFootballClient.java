package com.lewicki.betsbackend.client;

import com.lewicki.betsbackend.configuration.ApiFootballConfig;
import com.lewicki.betsbackend.domain.LeagueIds;
import com.lewicki.betsbackend.domain.league.League;
import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.domain.team.Player;
import com.lewicki.betsbackend.domain.team.Team;
import com.lewicki.betsbackend.service.LeagueIdsService;
import com.lewicki.betsbackend.service.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.context.event.EventListener;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiFootballClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LeagueIdsService leagueIdsService;

    @Autowired
    private TeamInfoService teamInfoService;

    @Autowired
    private ApiFootballConfig apiFootballConfig;

    public List<Player> getTeamSquad(String name) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HttpHeaderInterceptor("X-RapidAPI-Key", apiFootballConfig.getApiFootballKey()));
        interceptors.add(new HttpHeaderInterceptor("Accept", "application/json"));

        restTemplate.setInterceptors(interceptors);
        Team team = restTemplate.getForObject(apiFootballConfig.getApiFootballEndpoint() + "/players/squad/" + teamInfoService.getTeam(name).getTeam_id() + "/2018-2019",
                Team.class);

        return team.getApi().getPlayers();
    }

    public List<TeamInfo> getLeagueInfo(String name) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HttpHeaderInterceptor("X-RapidAPI-Key", apiFootballConfig.getApiFootballKey()));
        interceptors.add(new HttpHeaderInterceptor("Accept", "application/json"));

        restTemplate.setInterceptors(interceptors);
        League league = restTemplate.getForObject(apiFootballConfig.getApiFootballEndpoint() + "/teams/league/" + leagueIdsService.getLeague(name).getId(),
                League.class);

        return league.getApi().getTeams();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setLeagueIds(){
        ArrayList<LeagueIds> leagues = new ArrayList<>();
        leagues.add(new LeagueIds(2L,"Premier League"));
        leagues.add(new LeagueIds(4L,"Ligue1"));
        leagues.add(new LeagueIds(8L,"Bundesliga1"));
        leagues.add(new LeagueIds(28L,"SerieA"));
        leagues.add(new LeagueIds(30L,"Primera Division"));
        leagues.add(new LeagueIds(31L,"Champions League"));
        leagues.add(new LeagueIds(82L,"Super League"));
        leagues.add(new LeagueIds(517L,"Ekstraklasa"));

        leagueIdsService.saveLeagues(leagues);
    }
}
