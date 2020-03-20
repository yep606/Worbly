package base.controller;


import base.domain.User;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String chatPage(Model model,
                           @AuthenticationPrincipal User user) {

        model.addAttribute("name", user.getUsername());
        model.addAttribute("image", user.getImageName());

        return "index";

    }

}
