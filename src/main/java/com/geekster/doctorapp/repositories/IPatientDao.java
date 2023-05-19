package com.geekster.doctorapp.repositories;

import com.geekster.doctorapp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientDao extends JpaRepository<Patient,Long> {
    Patient findFirstByPatientEmail(String userEmail);
}
