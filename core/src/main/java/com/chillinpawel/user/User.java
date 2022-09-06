package com.chillinpawel.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class User {

    // fields
    private int invalidLogins = 0;
    private boolean loggedIn = false;
    @Setter(AccessLevel.PACKAGE)
    private boolean userLocked = false;
    private String login;
    private String email;
    @Getter(AccessLevel.NONE)
    private String password;

    // constructors
    public User() {
    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    // public methods
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

    public String logOut() {
        loggedIn = false;
        return "User logged out";
    }

    public String changePassword(String newPassword) {
        if (userLocked) {
            return "User locked";
        }
        // basic verification of password len - will add regex check
        if (newPassword.length() > 7) {
            this.password = newPassword;
            return "Password has been changed";
        }
        return "Password does not meet criteria";

    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())){
            return this.login.equals(((User) obj).login);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Login: '" + login + "'\n" +
                "Email: '" + email + "'";
    }
}
