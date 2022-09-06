package com.chillinpawel;

import com.chillinpawel.user.MemoryUserManager;
import com.chillinpawel.user.User;

public class Main {

    public static void main(String[] args) {
        MemoryUserManager memoryUserManager = new MemoryUserManager();

        for(User user : memoryUserManager.getUsers()){
            System.out.println(user);
        }
    }
}
