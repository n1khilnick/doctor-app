package com.geekster.doctorapp.repositories;

import com.geekster.doctorapp.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorDao extends JpaRepository<Doctor,Long> {
        Doctor findByDoctorId(Long docId);
}
