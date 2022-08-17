package com.chillinpawel.users;

public interface User {

    // should be moved to UserManager or something
    String register();

    String logIn();

    String logOut();

    String changePassword(String newPassword);

    String restoreLogin();

}
