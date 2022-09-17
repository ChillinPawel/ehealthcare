package com.chillinpawel.user;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Slf4j
public class UserService {

    // fields
    private final Set<User> users = new HashSet<>();

    // constructors
    public UserService() {

        // some dummy records for start
        registerUser(new Admin("user1", "admin1@com.pl", "xyzc"));
        registerUser(new Admin("user1", "admin2@com.pl", "xyzc"));
        registerUser(new Doctor("user1", "doctor@com.pl", "xyzc"));
        registerUser(new Patient("user1", "patient@com.pl", "xyzc"));
    }

    // public methods
    public Set<User> getAllUsers(){
        return users;
    }

    public User getUser(String login) throws NoSuchElementException {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst().get();
    }

    public void registerUser(@NonNull User user) {
        if(!users.contains(user)){
            users.add(user);
        } else{
            // for now just log INFO
            log.info("User already in database...");
        }
    }

    public void updateUser(@NonNull User user, String login){
        this.deleteUser(login);
        this.registerUser(user);
    }

    public void deleteUser(String login) {
        users.removeIf(u -> u.getLogin().equals(login));
    }


}
