package com.posSeystem.PosSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.User;
import com.posSeystem.PosSystem.repository.Userrepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private Userrepository userrepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

   
    @Override
    public User creatUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       return userrepository.save(user);
    }
    
}
