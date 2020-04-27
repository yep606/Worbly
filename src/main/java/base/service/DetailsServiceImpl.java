package base.service;

import base.domain.Role;
import base.domain.User;
import base.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

@Service
public class DetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User userFromDB = userRepo.findByUserName(userName);

        if (userFromDB == null)
            throw new UsernameNotFoundException("User not found!");

        return userFromDB;
    }

    public boolean addUser(User user) {

        if (userRepo.findByUserName(user.getUserName()) != null)
            return false;

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        user.setCurrentRoom("");
        user.setImageName("classic.jpg");
        userRepo.save(user);

        return true;
    }

    public boolean updateProfile(User user, String newPassword) {

        if (!StringUtils.isEmpty(newPassword)) {
            user.setPassword(newPassword);
            userRepo.save(user);
            return true;
        } else
            return false;
    }

    public String updateImage(User user, MultipartFile file) throws IOException {

        String uuidFile = UUID.randomUUID().toString();
        String imageName = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadPath + "/" + imageName));

        user.setImageName(imageName);
        userRepo.save(user);

        return imageName;


    }
}
