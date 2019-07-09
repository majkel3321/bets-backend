package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UsersRepository usersRepository;

    public void addUser(User user){
        usersRepository.save(user);
    }

    public List<User> getUsers(){
        return usersRepository.findAll();
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public Optional<User> getUser(Long id){
        return usersRepository.findById(id);
    }
}
