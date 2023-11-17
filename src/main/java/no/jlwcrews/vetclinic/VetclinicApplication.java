package no.jlwcrews.vetclinic;

import no.jlwcrews.vetclinic.model.*;
import no.jlwcrews.vetclinic.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class VetclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetclinicApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			PetRepo petRepo,
			OwnerRepo ownerRepo,
			VetRepo vetRepo,
			RoomRepo roomRepo,
			AppointmentRepo appointmentRepo
			) {

		return args -> {
			Owner owner = ownerRepo.save(new Owner("Jason", "j@a.b"));
			Pet pet = petRepo.save(new Pet("Bob", "Turtle"));
			owner.getPets().add(pet);
			ownerRepo.save(owner);
			Vet vet = vetRepo.save(new Vet("Ted"));
			Room room = roomRepo.save(new Room("exam room"));
			Appointment appt = new Appointment(LocalDateTime.now(), 1L);
			appt.setRoom(room);
			appt.setPet(pet);
			appt.setVet(vet);
			appointmentRepo.save(appt);
		};
	}

}
