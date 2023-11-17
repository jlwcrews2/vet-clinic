package no.jlwcrews.vetclinic.service;

import no.jlwcrews.vetclinic.model.Appointment;
import no.jlwcrews.vetclinic.repo.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private String dogName;

    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public List<Appointment> getAppointments(){
        return appointmentRepo.findAll();
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepo.findById(id).orElse(null);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }
}
