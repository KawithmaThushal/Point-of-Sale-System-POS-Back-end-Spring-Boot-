package com.posSeystem.PosSystem.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.User;
import com.posSeystem.PosSystem.repository.Userrepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private Userrepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userrepository.findByUsername(username).orElse(null);


        if(user == null){
            throw new UsernameNotFoundException("User is not found");

        }else{
            return org.springframework.security.core.userdetails.User.builder()
         
            .username(user.getUsername())
            .password(user.getPassword())
            .build();
        }
    }
    
}
