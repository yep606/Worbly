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

import java.util.Collections;

@Service
public class DetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User userFromDB = userRepo.findByUserName(userName);
        System.out.println(userFromDB.getRoles());

        return userFromDB;
    }

    public boolean addUser(User user) {

        System.out.println(user.getUserName());

        if(userRepo.findByUserName(user.getUserName()) != null)
            return false;

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return true;
    }
}
