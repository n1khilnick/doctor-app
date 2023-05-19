package com.geekster.doctorapp.repositories;

import com.geekster.doctorapp.models.AuthenticationToken;
import com.geekster.doctorapp.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenDao extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
