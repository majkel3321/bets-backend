package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public Optional<User> getUser(Long id) {
        return usersRepository.findById(id);
    }

    public boolean logIn(String username, String password) {

        if (usersRepository.findAllByLoggedInIsTrue().size() == 0) {
            usersRepository.findByUsernameAndPassword(username, password)
                    .ifPresent(user -> {
                        user.setLoggedIn(true);
                        usersRepository.save(user);
                    });
            return true;
        }

        return false;
    }

    public Optional<User> getLoggedUser() {
        return usersRepository.findByLoggedInIsTrue();
    }

    public boolean logOut(String username) {

        if (usersRepository.findByUsername(username).isPresent()) {
            usersRepository.findByUsername(username)
                    .ifPresent(user -> {
                        user.setLoggedIn(false);
                        usersRepository.save(user);
                    });
            return true;
        }

        return false;
    }

    public boolean updateBalance(Long userId, double amount) {
        double balance = usersRepository.findById(userId).get().getBalance();

        if (balance - amount > 0) {
            usersRepository.findById(userId)
                    .ifPresent(user -> {
                        user.setBalance(balance - amount);
                        usersRepository.save(user);
                    });
            return true;
        }

        return false;
    }
}
