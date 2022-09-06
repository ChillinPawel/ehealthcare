package com.chillinpawel.user;

public class Admin extends User{

    // constructors
    public Admin(String login, String email, String password) {
        super(login, email, password);
    }

    // public methods
    public void UnlockUser(User user){
        if(isLoggedIn() && user.isUserLocked()){
            user.setUserLocked(false);
        }
    }

    public void LockUser(User user){
        if(isLoggedIn() && user.isUserLocked()){
            user.setUserLocked(true);
        }
    }

}
