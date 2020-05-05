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

    private final UserRepo userRepo;
    private final RoomService roomService;

    @Autowired
    public RoomController(UserRepo userRepo, RoomService roomService) {
        this.userRepo = userRepo;
        this.roomService = roomService;
    }

    @GetMapping("{subject}")
    public Room availableRoom(@PathVariable String subject, @AuthenticationPrincipal User user){

        System.out.println(subject);
        Room room = roomService.findFreeRoom(subject);

        user.setRoom(room);
        userRepo.save(user);

        return room;
    }



}
