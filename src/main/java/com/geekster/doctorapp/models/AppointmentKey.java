package com.geekster.doctorapp.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentKey implements Serializable { //serializable - bytes


    public Long appointmentId;
    public LocalDateTime time;
}
