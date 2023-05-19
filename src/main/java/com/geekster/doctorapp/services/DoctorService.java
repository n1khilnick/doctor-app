package com.geekster.doctorapp.services;

import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.models.Doctor;
import com.geekster.doctorapp.repositories.IDoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorDao doctorDao;

    public void addDoctor(Doctor doctor) {
        doctorDao.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDao.findAll();
    }

    public List<Appointment> getMyAppointments(Long doctorId) {
        Doctor myDoctor = doctorDao.findByDoctorId(doctorId);

        if(myDoctor == null){
            throw new IllegalStateException("Doctor doesn't exists !!");
        }
        return myDoctor.getAppointments();
    }
}
