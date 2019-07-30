package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import com.lewicki.betsbackend.repository.TeamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamInfoService {

    @Autowired
    private TeamInfoRepository teamInfoRepository;

    public void saveTeams(List<TeamInfo> teams){
        for (TeamInfo teamInfo: teams){
            teamInfoRepository.save(teamInfo);
        }
    }

    public TeamInfo getTeam(String name){
        return teamInfoRepository.findByName(name).orElse(new TeamInfo("empty"));
    }

    public void deleteTeam(Long id){
        teamInfoRepository.deleteById(id);
    }
}
