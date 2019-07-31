package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.league.TeamInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamInfoRepository extends CrudRepository<TeamInfo,Long> {

    List<TeamInfo> findAll();

    Optional<TeamInfo> findByName(String name);
}
