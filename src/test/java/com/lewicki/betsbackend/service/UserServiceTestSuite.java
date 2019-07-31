package com.lewicki.betsbackend.service;

import com.lewicki.betsbackend.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    private UserService userService;

    private List<User> users;

    @Before
    public void createAndSaveUsers(){
        User user1 = new User("Walter1","Walter1","walter1@email.com");
        User user2 = new User("Walter2","Walter2","walter2@email.com");
        User user3 = new User("Walter3","Walter3","walter3@email.com");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        users = userService.getUsers();
    }

    @After
    public void cleanUp(){
        userService.deleteUser(users.get(0).getId());
        userService.deleteUser(users.get(1).getId());
        userService.deleteUser(users.get(2).getId());
    }

    @Test
    public void testGetUsers(){
        //Give&When&Then
        assertEquals(3,users.size());
        assertEquals("Walter2",users.get(1).getUsername());
    }

    @Test
    public void testSaveUser(){
        //Given
        User user = new User("Walter","Walter1","walter@email.com");

        //When
        userService.addUser(user);

        //Then
        Assert.assertEquals(4, userService.getUsers().size());

        //CleanUp
        userService.deleteUser(userService.getUsers().get(3).getId());
    }

    @Test
    public void testDeleteUser(){
        //Given
        User user = new User("Walter","Walter1","walter@email.com");

        userService.addUser(user);
        List<User> users1 = userService.getUsers();

        //When
        userService.deleteUser(userService.getUsers().get(3).getId());

        //Then
        assertEquals(4,users1.size());
        assertEquals(3,userService.getUsers().size());
    }

    @Test
    public void testGetUser() throws Exception {
        //Given&When
        User user = userService.getUser(users.get(2).getId()).orElseThrow(Exception::new);

        //Then
        assertEquals("Walter3",user.getUsername());
    }

    @Test
    public void testLogIn(){
        //Given&When
        userService.logIn("Walter1","Walter1");

        //Then
        assertTrue(userService.getUsers().get(0).isLoggedIn());
    }

    @Test
    public void testGetLoggedUser() throws Exception {
        //Given
        userService.logIn("Walter2","Walter2");

        //When
        User user = userService.getLoggedUser().orElseThrow(Exception::new);

        //Then
        assertEquals("walter2@email.com",user.getEmail());
    }

    @Test
    public void testLogOut() throws Exception {
        //Given
        userService.logIn("Walter2","Walter2");
        User loggeduser = userService.getLoggedUser().orElseThrow(Exception::new);
        //Then
        userService.logOut("Walter2");

        //Then
        assertTrue(loggeduser.isLoggedIn());
        assertFalse(userService.getUser(users.get(1).getId()).get().isLoggedIn());
    }

    @Test
    public void testUpdateBalance(){
        //Given&When
        userService.updateBalance(users.get(0).getId(),100);

        //Then
        assertEquals(1100,userService.getUsers().get(0).getBalance());
    }
}
