package com.lewicki.betsbackend.mapper;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToUserDto(User user){
        return new UserDto(user.getUsername(),user.getPassword(),user.getEmail());
    }

    public User mapToUser(UserDto userDto){
        return new User(userDto.getUsername(),userDto.getPassword(),userDto.getEmail());
    }
}
