package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.client.LiveOddsClient;
import com.lewicki.betsbackend.domain.MatchDto;
import com.lewicki.betsbackend.mapper.MatchMapper;
import com.lewicki.betsbackend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private LiveOddsClient liveOddsClient;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private MatchService matchService;

    @GetMapping("all")
    public List<MatchDto> getMatches(@RequestParam("leagueName") String leagueName) {
        return matchMapper.mapToMatchDtoList(liveOddsClient.downloadMatches(leagueName));
    }

    @DeleteMapping("delete")
    public void deleteMatch(@RequestParam("id") Long id){
        matchService.deleteMatch(id);
    }
}
