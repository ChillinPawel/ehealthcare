package com.chillinpawel.user;

import com.chillinpawel.visit.MemoryVisitManager;
import com.chillinpawel.visit.VisitManager;

public class Doctor extends User {

    // fields
    private final VisitManager visitManager = new MemoryVisitManager();

    // constructors
    public Doctor(String login, String email, String password) {
        super(login, email, password);
    }
}
