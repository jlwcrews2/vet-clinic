package no.jlwcrews.vetclinic.service;


import no.jlwcrews.vetclinic.model.Room;
import no.jlwcrews.vetclinic.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepo roomrepo;

    @Autowired
    public RoomService(RoomRepo roomrepo) {
        this.roomrepo = roomrepo;
    }

    public Room getRoomById(Long id) {
        return roomrepo.findById(id).orElse(null);
    }

    public List<Room> getRooms() {
        return roomrepo.findAll();
    }

    public Room createRoom(Room Room) {
        return roomrepo.save(Room);
    }

    public void deleteRoom(Long id) {
        roomrepo.deleteById(id);
    }
}
