package com.lewicki.betsbackend.mapper;

import com.lewicki.betsbackend.domain.User;
import com.lewicki.betsbackend.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapToUserDto(){
        //Given
        User user = new User("username1","password1","email1");

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals("username1",userDto.getUsername());
    }

    @Test
    public void testMapToUser(){
        //Given
        UserDto userDto = new UserDto("username1","password1","email1");

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals("email1",user.getEmail());
    }
}
