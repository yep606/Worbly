package base.service;

import base.domain.User;
import base.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

    public String getCurrentPrincipalName(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();


    }
}
