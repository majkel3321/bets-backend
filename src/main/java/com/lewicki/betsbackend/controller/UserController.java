package com.lewicki.betsbackend.controller;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.domain.UserDto;
import com.lewicki.betsbackend.mapper.UserMapper;
import com.lewicki.betsbackend.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Service service;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser")
    public User getUser(@RequestParam Long id) {
        return service.getUser(id).orElse(new User("empty", "empty"));
    }

    @GetMapping("getUsers")
    public List<User> getAllUsers() {
        return service.getUsers();
    }

    @PostMapping("createUser")
    public void createUser(@RequestBody UserDto userDto) {
        service.addUser(userMapper.mapToUser(userDto));
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
    }
}
