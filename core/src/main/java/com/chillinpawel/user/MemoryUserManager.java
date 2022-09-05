package com.chillinpawel.user;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MemoryUserManager implements UserManager {

    // fields
    private final Set<User> users = new HashSet<>();

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
