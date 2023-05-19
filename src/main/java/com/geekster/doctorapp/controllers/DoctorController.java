package com.geekster.doctorapp.controllers;

import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.models.Doctor;
import com.geekster.doctorapp.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/")
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    @GetMapping("{doctorId}/appointments/")
    ResponseEntity<List<Appointment>> getDocMyAppointments(@PathVariable Long doctorId){
        List<Appointment> myAppointments = doctorService.getMyAppointments(doctorId);
        HttpStatus status;
        try {
               if(myAppointments.isEmpty()){
                    status = HttpStatus.NO_CONTENT;
               }
               else{
                   status = HttpStatus.OK;
               }
        }catch (Exception ex){
            System.out.println("Id "+doctorId+" is not valid");
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<List<Appointment>>(myAppointments,status);
    }

}
