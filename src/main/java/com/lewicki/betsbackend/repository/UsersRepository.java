package com.lewicki.betsbackend.repository;

import com.lewicki.betsbackend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User,Long> {

    @Override
    List<User> findAll();

    void deleteById(Long id);

    Optional<User> findById(Long id);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
