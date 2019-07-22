package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.MatchDto;
import com.lewicki.betsbackend.domain.odds.Odd;
import com.lewicki.betsbackend.mapper.MatchMapper;
import com.lewicki.betsbackend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchMapper matchMapper;

    public List<MatchDto> getMatches(){
        return (List<MatchDto>) matchRepository.findAll();
    }

    public void saveMatches(Odd odd){
        List<MatchDto> matches = matchMapper.mapToMatchDtoList(odd);

        for (MatchDto match: matches){
            matchRepository.save(match);
        }
    }
}
