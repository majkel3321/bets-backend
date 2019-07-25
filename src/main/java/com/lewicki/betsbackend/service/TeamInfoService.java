package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.repository.TeamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamInfoService {

    @Autowired
    private TeamInfoRepository repository;

    public void saveTeams(List<TeamInfo> teams){
        for (TeamInfo teamInfo: teams){
            repository.save(teamInfo);
        }
    }

    public TeamInfo getTeam(String name){
        return repository.findByName(name).orElse(new TeamInfo("empty"));
    }
}
