package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.domain.UserDto;
import com.lewicki.betsbackend.mapper.UserMapper;
import com.lewicki.betsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public User getUser(@RequestParam("id") Long id) {
        return userService.getUser(id).orElse(new User("username", "password","email"));
    }

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("logged")
    public User getLoggedUser(){
        return userService.getLoggedUser().get();
    }

    @PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.addUser(userMapper.mapToUser(userDto));
    }

    @DeleteMapping("delete")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("login")
    public boolean logIn(@RequestParam String username, @RequestParam String password){
        return userService.logIn(username,password);
    }

    @PutMapping("logout")
    public boolean logOut(@RequestParam String username){
        return userService.logOut(username);
    }

    @PutMapping("updateBalance")
    public boolean updateAccountBalance(@RequestParam Long userId, @RequestParam double amount){
       return userService.updateBalance(userId,amount);
    }
}
