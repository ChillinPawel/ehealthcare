package com.chillinpawel.visit;

import com.chillinpawel.user.Patient;
import lombok.Data;

import java.util.Date;

@Data
public class Visit {

    // fields
    private final Date bookingTime;
    private Patient patient;
    private boolean booked = false;

    // constructors
    public Visit(Date bookingTime) {
        this.bookingTime = bookingTime;
    }
}
