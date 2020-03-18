package base.service;

import base.domain.Role;
import base.domain.User;
import base.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service
public class DetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User userFromDB = userRepo.findByUserName(userName);

        if(userFromDB == null)
            throw new UsernameNotFoundException("User not found!");

        return userFromDB;
    }

    public boolean addUser(User user) {

        if (userRepo.findByUserName(user.getUserName()) != null)
            return false;

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return true;
    }

    //fix!!!
    public boolean updateProfile(User user, String newPassword) {

        if (!StringUtils.isEmpty(newPassword)) {
            user.setPassword(newPassword);
            userRepo.save(user);
            return true;
        } else
            return false;
    }
}
