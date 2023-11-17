package no.jlwcrews.vetclinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq_gen")
    @SequenceGenerator(name = "room_seq_gen", sequenceName = "room_seq", allocationSize = 1)
    @Column(name = "room_id")
    private Long roomId = 0L;

    @Column(name = "room_name")
    private String roomName;

    public Room(String roomName) {
        this.roomName = roomName;
    }
}
