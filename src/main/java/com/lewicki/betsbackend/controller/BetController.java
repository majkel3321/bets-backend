package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.Bet;
import com.lewicki.betsbackend.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping(value = "createBet",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBet(@RequestBody Bet bet){
        System.out.println(bet);
        betService.saveBet(bet);
    }
}
