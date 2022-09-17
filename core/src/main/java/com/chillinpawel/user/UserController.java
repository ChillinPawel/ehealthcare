package com.chillinpawel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{login}")
    public User getUser(@PathVariable String login){
        return userService.getUser(login);
    }

    @RequestMapping(method= RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user){
        userService.registerUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{login}")
    public void updateUser(@RequestBody User user, @PathVariable String login){
        userService.updateUser(user, login);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{login}")
    public void updateUser(@PathVariable String login){
        userService.deleteUser(login);
    }
}
