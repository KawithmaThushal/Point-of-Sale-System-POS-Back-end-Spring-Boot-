package com.posSeystem.PosSystem.Service;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.User;

@Service
public interface UserService {

    User creatUser(User user);
    
} 
