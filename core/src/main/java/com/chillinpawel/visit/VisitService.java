package com.chillinpawel.visit;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class VisitService {

    // fields
    private final Set<Visit> visits = new HashSet<>();

    // public methods
    public void addVisit(Visit visit) {
        if(!visits.contains(visit)){
            visits.add(visit);
        } else {
            log.info("Visit already in database");
        }
    }

    public void updateVisit(Visit visit) {
        this.deleteVisit(visit);
        this.addVisit(visit);
    }

    public void deleteVisit(Visit visit) {
        if(visits.remove(visit)){
            log.info("Visit removed from database");
        } else {
            log.info("Visit already in database");
        }
    }
}
