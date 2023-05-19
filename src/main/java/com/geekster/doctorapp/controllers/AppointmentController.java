package com.geekster.doctorapp.controllers;

import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;


}
