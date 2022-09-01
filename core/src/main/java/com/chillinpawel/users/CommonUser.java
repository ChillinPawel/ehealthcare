package com.chillinpawel.users;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonUser implements User{

    // fields
    private int invalidLogins = 0;
    @Getter
    private String login;
    @Getter
    private String email;
    private String password;

    // constructors
    public CommonUser() {
    }

    public CommonUser(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    // public methods
    @Override
    public String logIn(String password) {
        if(password.equals(this.password)){
            invalidLogins = 0;
            return "User logged in";
        }
        invalidLogins++;
        return "Invalid password";
    }

    @Override
    public String logOut() {
        return "User logged out";
    }

    @Override
    public String changePassword(String newPassword) {
        // basic verification of password len
        if(newPassword.length() > 7){
            this.password = newPassword;
            return "Password has been changed";
        }
        return "Password does not meet criteria";

    }

    @Override
    public String restoreLogin() {
        return null;
    }


}
