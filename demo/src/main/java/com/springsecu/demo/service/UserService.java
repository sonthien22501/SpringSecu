package com.springsecu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecu.demo.entity.CustomUserDetails;
import com.springsecu.demo.entity.User;
import com.springsecu.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
       User user = userRepository.findByUsername(username);
       if (user == null){
        throw new UsernameNotFoundException(username);
       }
       return new CustomUserDetails(user);
    }
    

}
