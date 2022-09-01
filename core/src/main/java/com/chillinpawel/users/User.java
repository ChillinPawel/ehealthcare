package com.chillinpawel.users;

public interface User {

    String logIn(String password);

    String logOut();

    String changePassword(String newPassword);

    String restoreLogin();

}
