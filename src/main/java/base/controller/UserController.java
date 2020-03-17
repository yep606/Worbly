package base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/user")
public class UserController {

    @GetMapping("profile")
    public String getUserProfile(Principal principal, Model model){




    }

}
