package com.chillinpawel.managers;

import com.chillinpawel.users.User;

public interface UserManager {
    void registerUser(User user);
    void deleteUser(User user);
}
