package com.chillinpawel.managers;

import com.chillinpawel.users.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MemoryUserManager implements UserManager{

    // fields
    private final List<User> users = new ArrayList<>();

    // public methods
    @Override
    public void registerUser(@NonNull User user) {
        if(!users.contains(user)){
            users.add(user);
        } else{
            // for now just log INFO
            log.info("User already in database...");
        }
    }

    @Override
    public void deleteUser(User user) {
        if(users.contains(user)){
            users.remove(user);
        } else{
            // for now just log INFO
            log.info("User not found in database...");
        }
    }
}
