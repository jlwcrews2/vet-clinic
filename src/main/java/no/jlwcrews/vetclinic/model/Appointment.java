package no.jlwcrews.vetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq_gen")
    @SequenceGenerator(name = "appointment_seq_gen", sequenceName = "appointment_seq", allocationSize = 1)
    @Column(name = "appointment_id")
    private Long appointmentId = 0L;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @Column(name = "appointment_duration")
    private Long appointmentDuration = 0L;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonIgnoreProperties("appointments")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    @JsonIgnoreProperties("appointments")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;




}
