package com.chillinpawel.user;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MemoryUserManager implements UserManager {

    // fields
    @Getter
    private final Set<User> users = new HashSet<>();

    // constructors
    public MemoryUserManager() {

        // some dummy records for start
        registerUser(new Admin("user1", "admin1@com.pl", "xyzc"));
        registerUser(new Admin("user1", "admin2@com.pl", "xyzc"));
        registerUser(new Doctor("user1", "doctor@com.pl", "xyzc"));
        registerUser(new Patient("user1", "patient@com.pl", "xyzc"));
    }

    // public methods
    @Override
    public User getUser(String login) {
        for(User user : users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

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
