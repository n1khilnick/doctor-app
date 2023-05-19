package com.geekster.doctorapp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    private String token;

    private LocalDate tokenCreationDate;

    @OneToOne
    @JoinColumn(name = "fk_patient_id",nullable = false)
    private Patient patient;

    public AuthenticationToken(Patient patient) {
        this.patient = patient;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }
}
