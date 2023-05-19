package com.geekster.doctorapp.services;

import com.geekster.doctorapp.dto.SignInInput;
import com.geekster.doctorapp.dto.SignInOutput;
import com.geekster.doctorapp.dto.SignUpInput;
import com.geekster.doctorapp.dto.SignUpOutput;
import com.geekster.doctorapp.models.AppointmentKey;
import com.geekster.doctorapp.models.AuthenticationToken;
import com.geekster.doctorapp.models.Doctor;
import com.geekster.doctorapp.repositories.IPatientDao;
import com.geekster.doctorapp.models.Patient;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientDao patientDao;

    @Autowired
    AuthenticationService tokenService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;


    public SignUpOutput signUp(SignUpInput signUpDto) {

        //checks if user exists or not based on email
        Patient patient = patientDao.findFirstByPatientEmail(signUpDto.getUserEmail());

        if(patient != null){
            throw new IllegalStateException("Patient already exists !! Sign-In instead");
        }

        //encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //save the user

        patient = new Patient(signUpDto.getUserFirstName(),signUpDto.getUserLastName(),
                  signUpDto.getUserEmail(),encryptedPassword,signUpDto.getUserContact());

        patientDao.save(patient);

        //token creation and saving : session

        AuthenticationToken token = new AuthenticationToken(patient);

        tokenService.saveToken(token);

        return new SignUpOutput("Signup Successfully !!","Patient created Successfully !!");
    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        System.out.println(hash);
        return hash;
    }


    public SignInOutput signIn(SignInInput signInDto) {

        //check user based on email
        Patient patient = patientDao.findFirstByPatientEmail(signInDto.getPatientEmail());

        if(patient == null){
                throw new IllegalStateException("User doesn't exists !! check details or Sign-up first");
        }

        //encrypt the password

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPatientPassword());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        //match it with database encrypted password

        boolean isPasswordValid  = encryptedPassword.equals(patient.getPatientPassword());

        if(!isPasswordValid){
            throw new IllegalStateException("User's details are invalid !! check details or Sign-up first");
        }

        //figure out the token

        AuthenticationToken auhToken = tokenService.getToken(patient);

        //set up output response

        return new SignInOutput("Authentication Successfully !!",auhToken.getToken());
    }

    public List<Doctor> fetchAllDoctors() {
            return doctorService.getAllDoctors();
    }

    public void cancelAppointments(AppointmentKey key) {
        appointmentService.cancelAppointments(key);
    }
}
