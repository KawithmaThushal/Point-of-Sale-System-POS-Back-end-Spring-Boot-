package com.posSeystem.PosSystem.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.Entity.User;
import com.posSeystem.PosSystem.Service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userservice;


    @PostMapping("/user")
    public User CreatUser(@RequestBody User entity) {
        return userservice.creatUser(entity);
    }
    
    
}
