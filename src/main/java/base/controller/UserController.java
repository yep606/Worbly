package base.controller;

import base.domain.User;
import base.repos.UserRepo;
import base.service.DetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    DetailsServiceImpl userService;
    @Autowired
    UserRepo userRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("profile")
    public String getUserProfile(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("username", user.getUserName());
        model.addAttribute("filename", user.getImageName());

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

    @PostMapping("image")
    public String updateImage(@AuthenticationPrincipal User user,
                              @RequestParam("file") MultipartFile file,
                              Model model) throws IOException {

        if (file != null) {

            String uuidFile = UUID.randomUUID().toString();
            String imageName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + imageName));

            user.setImageName(imageName);
            userRepo.save(user);

            model.addAttribute("filename", imageName);
            model.addAttribute("username", user.getUsername());
            System.out.println(imageName);
        }



        return "profile";

    }

}
