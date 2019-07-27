package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.Bet;
import com.lewicki.betsbackend.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;

    public void saveBet(Bet bet){
        betRepository.save(bet);
    }
}
