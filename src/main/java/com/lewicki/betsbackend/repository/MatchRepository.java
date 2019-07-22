package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.MatchDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<MatchDto,Long> {
}
