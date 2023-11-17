package no.jlwcrews.vetclinic.appointment;


import no.jlwcrews.vetclinic.model.Appointment;
import no.jlwcrews.vetclinic.repo.AppointmentRepo;
import no.jlwcrews.vetclinic.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AppointmentServiceUnitTest {

    @MockBean
    private AppointmentRepo appointmentRepo;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    void shouldFetchAllAppointments(){

        List<Appointment> appointmentList = List.of(new Appointment(), new Appointment());
        when(appointmentRepo.findAll()).thenReturn(appointmentList);

        var appointments = appointmentService.getAppointments();
        assert appointments.size() == 2;
    }

}
