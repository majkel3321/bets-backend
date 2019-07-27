package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<Bet,Long> {
}
