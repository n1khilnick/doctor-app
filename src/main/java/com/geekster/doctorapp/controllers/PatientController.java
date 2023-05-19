package com.geekster.doctorapp.controllers;

import com.geekster.doctorapp.dto.SignInInput;
import com.geekster.doctorapp.dto.SignInOutput;
import com.geekster.doctorapp.dto.SignUpInput;
import com.geekster.doctorapp.dto.SignUpOutput;
import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.models.AppointmentKey;
import com.geekster.doctorapp.models.Doctor;
import com.geekster.doctorapp.services.AppointmentService;
import com.geekster.doctorapp.services.AuthenticationService;
import com.geekster.doctorapp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authService;

    @Autowired
    AppointmentService appointmentService;

    //sign-up

    //sign-up input


    //sign-up output

    @PostMapping(value = "/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return patientService.signUp(signUpDto);
    }

    //sign-in

    @PostMapping(value = "/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return patientService.signIn(signInDto);
    }


    @PostMapping("/appointments")
    public void bookAppointment(@RequestBody Appointment appointment){
        appointmentService.bookAppointment(appointment);
    }


//    @DeleteMapping("/remove/{}")
//    ResponseEntity<Void> cancelAppointments(@RequestParam String userEmail, @RequestParam String token, @RequestBody AppointmentKey key){
//        HttpStatus status = null;
//
//        if(authService.authenticate(userEmail,token)){
//            patientService.cancelAppointments(key);
//        }else{
//            status = HttpStatus.FORBIDDEN;
//        }
//        return new ResponseEntity<Void>(status);
//    }

    @GetMapping(value = "/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String userEmail,@RequestParam String token){
            //Authenticate

        HttpStatus status;
        List<Doctor> allDoctors = null;
        if(authService.authenticate(userEmail,token)){

            allDoctors =  patientService.fetchAllDoctors();
            status = HttpStatus.OK;
        }
        else{
            status = HttpStatus.FORBIDDEN;
        }
         return new ResponseEntity<List<Doctor>>(allDoctors,status);
    }



}
