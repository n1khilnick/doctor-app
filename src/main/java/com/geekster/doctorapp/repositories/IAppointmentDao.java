package com.geekster.doctorapp.repositories;

import com.geekster.doctorapp.models.Appointment;
import com.geekster.doctorapp.models.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentDao extends JpaRepository<Appointment, AppointmentKey> {
}
