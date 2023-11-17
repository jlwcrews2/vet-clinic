package no.jlwcrews.vetclinic.appointment;

import jakarta.transaction.Transactional;
import no.jlwcrews.vetclinic.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceIntegrationTest {

    @Autowired
    AppointmentService appointmentService;

    @Test
    @Transactional
    void shouldFetchAppointments(){

        var appointments = appointmentService.getAppointments();

        assert appointments.size() == 1;
        assert appointments.get(0).getVet().getVetName().equals("Ted");
    }

}
