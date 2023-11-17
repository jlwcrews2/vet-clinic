package no.jlwcrews.vetclinic.repo;

import no.jlwcrews.vetclinic.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}
