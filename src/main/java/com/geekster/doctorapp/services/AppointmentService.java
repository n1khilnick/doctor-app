package com.geekster.doctorapp.services;

import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.models.AppointmentKey;
import com.geekster.doctorapp.repositories.IAppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    IAppointmentDao appointmentDao;

    public void bookAppointment(Appointment appointment) {
        appointmentDao.save(appointment);
    }

    public void cancelAppointments(AppointmentKey key) {
        appointmentDao.deleteById(key);
    }
}
