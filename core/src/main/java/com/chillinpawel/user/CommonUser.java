package com.chillinpawel.user;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonUser implements User{

    // fields
    private int invalidLogins = 0;
    private boolean loggedIn = false;
    private boolean userLocked = false;
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
        if(userLocked){
            return "User locked";
        }
        if(password.equals(this.password)){
            invalidLogins = 0;
            loggedIn = true;
            return "User logged in";
        }
        invalidLogins++;
        if(invalidLogins > 5){
            userLocked = true;
        }
        return "Invalid password";
    }

    @Override
    public String logOut() {
        loggedIn = false;
        return "User logged out";
    }

    @Override
    public String changePassword(String newPassword) {
        if(userLocked){
            return "User locked";
        }
        // basic verification of password len - will add regex check
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


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())){
            return this.login.equals(((CommonUser) obj).login);
        }
        return false;
    }
}
