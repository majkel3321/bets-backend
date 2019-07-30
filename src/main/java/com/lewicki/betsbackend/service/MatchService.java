package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.MatchDto;
import com.lewicki.betsbackend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<MatchDto> getMatches(){
        return (List<MatchDto>) matchRepository.findAll();
    }

    public void saveMatches(List<MatchDto> matches){
        matchRepository.saveAll(matches);
    }

    public void deleteMatch(Long id){
        matchRepository.deleteById(id);
    }
}
