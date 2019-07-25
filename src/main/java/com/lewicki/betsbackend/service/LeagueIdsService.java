package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.LeagueIds;
import com.lewicki.betsbackend.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueIdsService {

    @Autowired
    private LeagueRepository leagueRepository;

    public void saveLeagues(List<LeagueIds> leagues){
        leagues.stream().forEach(leagueIds -> {
            leagueRepository.save(leagueIds);
        });
    }

    public LeagueIds getLeague(String name){
        return leagueRepository.findByName(name).orElse(new LeagueIds(1L,"empty"));
    }
}
