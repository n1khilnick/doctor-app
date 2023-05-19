package com.geekster.doctorapp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.doctorapp.models.enums.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Appointment.class,property = "id")

public class Appointment {
    @Id
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AppointmentKey id;

    @ManyToOne
    @JoinColumn(name = "fk_doctor_doc_id")
    private Doctor doctor;

    @OneToOne
    private Patient patient;


}
