package base.controller;

import base.domain.Room;
import base.domain.User;
import base.repos.RoomRepo;
import base.repos.UserRepo;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    private final RoomRepo roomRepo;
    private final UserRepo userRepo;

    @Autowired
    public RoomController(RoomRepo roomRepo, UserRepo userRepo) {
        this.roomRepo = roomRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("{subject}")
    public Room availableRoom(@PathVariable String subject, @AuthenticationPrincipal User user){

        List<Room> test = roomRepo.findByAvailableAndSubject(true, subject);
        System.out.println(test);
        if(test.isEmpty()){
            Room newRoom = new Room();
            newRoom.setSubject(subject);
            newRoom.setAvailable(true);

            return roomRepo.save(newRoom);
        }
        return null;
    }



}
