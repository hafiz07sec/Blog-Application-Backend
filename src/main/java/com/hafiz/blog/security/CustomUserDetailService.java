package com.hafiz.blog.security;

import com.hafiz.blog.entities.User;
import com.hafiz.blog.exceptions.ResourceNotFoundException;
import com.hafiz.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //loading user from database by username
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email" + username, 0));

        return user;
    }
}
