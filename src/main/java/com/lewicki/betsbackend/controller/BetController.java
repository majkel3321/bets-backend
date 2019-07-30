package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.Bet;
import com.lewicki.betsbackend.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBet(@RequestBody Bet bet){
        betService.saveBet(bet);
    }

    @GetMapping("all")
    public List<Bet> getBets(){
       return betService.getBets();
    }

    @DeleteMapping("delete")
    public void deleteBet(@RequestParam("id") Long id){
        betService.deleteBet(id);
    }
}
