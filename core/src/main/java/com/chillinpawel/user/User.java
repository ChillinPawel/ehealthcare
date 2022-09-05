package com.chillinpawel.user;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

public interface User {

    String logIn(String password);

    String logOut();

    String changePassword(String newPassword);

    String restoreLogin();

    @Slf4j
    class MemoryUserManager implements UserManager {

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

    interface UserManager {
        void registerUser(User user);
        void deleteUser(User user);
    }
}
