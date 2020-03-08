package base.controller;


import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    DetailsServiceImpl userService;

    @GetMapping("/greeting")
    public String mainPage(){

        return "hello";

    }

    @GetMapping("/chat")
    public String chatPage(Model model, Principal principal){
        model.addAttribute("name", principal.getName());

        return "index";

    }

}
