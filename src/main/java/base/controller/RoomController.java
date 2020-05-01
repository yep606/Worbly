package base.controller;

import base.domain.Room;
import base.repos.RoomRepo;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("room")
public class RoomController {

    private final DetailsServiceImpl service;
    private final RoomRepo roomRepo;

    @Autowired
    public RoomController(DetailsServiceImpl repo, RoomRepo roomRepo) {
        this.service = repo;
        this.roomRepo = roomRepo;
    }

    @GetMapping
    public Room availableRoom(){


        return;
    }



}
