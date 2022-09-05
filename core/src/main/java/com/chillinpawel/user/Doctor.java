package com.chillinpawel.user;

import com.chillinpawel.visit.MemoryVisitManager;
import com.chillinpawel.visit.VisitManager;

public class Doctor extends CommonUser{

    // fields
    private final VisitManager visitManager = new MemoryVisitManager();



}
