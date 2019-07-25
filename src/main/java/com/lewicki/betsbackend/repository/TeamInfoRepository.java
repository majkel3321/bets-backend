package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamInfoRepository extends CrudRepository<TeamInfo,Long> {

    Optional<TeamInfo> findByName(String name);
}
