package base.controller;

import base.domain.User;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    DetailsServiceImpl userService;

    @GetMapping("profile")
    public String getUserProfile(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("username", user.getUserName());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                Model model) {
        if (userService.updateProfile(user, password))
            model.addAttribute("result", "Success");
        else
            model.addAttribute("result", "Something went wrong");

        return "profile";
    }

}
