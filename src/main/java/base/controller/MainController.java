package base.controller;


import base.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


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
