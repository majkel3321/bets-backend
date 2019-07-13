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

    @GetMapping("getUser")
    public User getUser(@RequestParam Long id) {
        return userService.getUser(id).orElse(new User("username", "password","email"));
    }

    @GetMapping("getUsers")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "createUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.addUser(userMapper.mapToUser(userDto));
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("login")
    public User logIn(@RequestParam String username, @RequestParam String password){
        return userService.logIn(username,password).orElse(new User("username","password","email"));
    }
}
