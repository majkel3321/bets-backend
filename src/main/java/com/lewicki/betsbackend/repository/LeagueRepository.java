package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.LeagueIds;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends CrudRepository<LeagueIds,Long> {

    Optional<LeagueIds> findByName(String name);
}
