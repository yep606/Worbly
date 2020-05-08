package base.service;

import base.domain.Room;
import base.repos.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room findFreeRoom(String subject) {

        System.out.println(roomRepo);
        Room newRoom;
        List<Room> test = roomRepo.findByAvailableAndSubject(true, subject);

        if (test.isEmpty()) {
            newRoom = new Room();
            newRoom.setSubject(subject);
            newRoom.setAvailable(true);
            newRoom.setPeople(1);
            return roomRepo.save(newRoom);
        }

        newRoom = test.get(0);
        newRoom.setPeople(2);
        newRoom.setAvailable(false);


        return roomRepo.save(newRoom);
    }
}
