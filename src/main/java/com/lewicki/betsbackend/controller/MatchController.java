package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.client.LiveOddsClient;
import com.lewicki.betsbackend.domain.MatchDto;
import com.lewicki.betsbackend.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private LiveOddsClient liveOddsClient;

    @Autowired
    private MatchMapper matchMapper;

    @GetMapping
    public List<MatchDto> getMatches() {
        return matchMapper.mapToMatchDtoList(liveOddsClient.downloadMatches());
    }
}
