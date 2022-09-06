package com.chillinpawel.user;

public interface UserManager {
    User getUser(String login);
    void registerUser(User user);
    void deleteUser(User user);
}
