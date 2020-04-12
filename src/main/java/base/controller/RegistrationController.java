package base.controller;

import base.domain.User;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    DetailsServiceImpl userService;

    @GetMapping("/registration")
    public String regPage(){

        return "registrationPage";

    }

    @PostMapping("/registration")
    public String addNewUser(User user, Model model){
        System.out.println("REGISTER");
        if(!userService.addUser(user)){

            model.addAttribute("error", "This username already exists, try another one");
            return "registrationPage";
        }

        return "redirect:/login";



    }


}
