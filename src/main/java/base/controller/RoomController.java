package base.controller;

import base.domain.User;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("room")
public class RoomController {

    private final DetailsServiceImpl repo;

    @Autowired
    public RoomController(DetailsServiceImpl repo) {
        this.repo = repo;
    }

    @GetMapping("{id}")
    public HashMap<String, String> getOneMessage(@PathVariable("id") User user){

        HashMap<String,String> hash = new HashMap<>();
        hash.put("id", "Hello, world!");

        return hash;
    }


}
