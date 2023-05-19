package com.geekster.doctorapp.services;

import com.geekster.doctorapp.models.AuthenticationToken;
import com.geekster.doctorapp.models.Patient;
import com.geekster.doctorapp.repositories.ITokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    ITokenDao tokenDao;

    public void saveToken(AuthenticationToken token){
        tokenDao.save(token);
    }


    public AuthenticationToken getToken(Patient patient) {
         return tokenDao.findByPatient(patient);
    }

    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authToken = tokenDao.findFirstByToken(token);

        String expected =  authToken.getPatient().getPatientEmail();

        return expected.equals(userEmail);
    }
}
