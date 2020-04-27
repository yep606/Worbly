package base.controller;

import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("room")
public class RoomController {

    private final DetailsServiceImpl repo;

    @Autowired
    public RoomController(DetailsServiceImpl repo) {
        this.repo = repo;
    }

    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
}
