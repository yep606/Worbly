package base.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greeting")
public class MainController {

    @GetMapping
    public String mainPage(){

        return "hello";

    }

    @GetMapping("/chat")
    public String chatPage(){

        return "index";

    }
}
