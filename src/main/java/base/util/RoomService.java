package base.util;

import base.domain.Room;
import base.repos.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoomService {

    @Autowired
    private static RoomRepo roomRepo;




    public static Room findFreeRoom(String subject) {

        List<Room> test = roomRepo.findByAvailableAndSubject(true, subject);

        if (test.isEmpty()) {
            Room newRoom = new Room();
            newRoom.setSubject(subject);
            newRoom.setAvailable(true);
            newRoom.setPeople(1);
            roomRepo.save(newRoom);
        }

        return null;
    }
}
