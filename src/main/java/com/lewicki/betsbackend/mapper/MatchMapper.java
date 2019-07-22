package com.lewicki.betsbackend.mapper;

import com.lewicki.betsbackend.domain.MatchDto;
import com.lewicki.betsbackend.domain.odds.Datum;
import com.lewicki.betsbackend.domain.odds.Odd;
import com.lewicki.betsbackend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchMapper {

    @Autowired
    private MatchRepository matchRepository;

   /* public void mapToMatchDto(Odd odd){
        for (Datum data: liveOddsClient.getOdd().getData()){
            matchRepository.save(new MatchDto(data.getTeams().get(0),data.getTeams().get(1),data.getSites().get(0).getOdds().getH2h().get(0),
                    data.getSites().get(0).getOdds().getH2h().get(1),data.getSites().get(0).getOdds().getH2h().get(2)));
        }
    }*/

    public List<MatchDto> mapToMatchDtoList(Odd odd){
        List<MatchDto> matches = new ArrayList<>();

        for (Datum data: odd.getData()){
            matches.add(new MatchDto(data.getTeams().get(0),data.getTeams().get(1),data.getSites().get(0).getOdds().getH2h().get(0),
                    data.getSites().get(0).getOdds().getH2h().get(1),data.getSites().get(0).getOdds().getH2h().get(2)));
        }

        return matches;
    }
}
