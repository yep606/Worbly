package base.controller;

import base.domain.Room;
import base.domain.User;
import base.repos.RoomRepo;
import base.repos.UserRepo;
import base.util.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


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

    @Bean
    public RoomService roomService(){

        return new RoomService(roomRepo);

    }

    @GetMapping("{subject}")
    public Room availableRoom(@PathVariable String subject, @AuthenticationPrincipal User user){

        RoomService.findFreeRoom(subject);

        if(test.isEmpty()){
            Room newRoom = new Room();
            newRoom.setSubject(subject);
            newRoom.setAvailable(true);
            roomRepo.save(newRoom);
            user.setRoom(newRoom);
            userRepo.save(user);
            return newRoom;
        }
        return null;
    }



}
