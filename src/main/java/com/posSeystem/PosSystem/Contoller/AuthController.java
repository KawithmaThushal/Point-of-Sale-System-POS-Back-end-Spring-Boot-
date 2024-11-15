package com.posSeystem.PosSystem.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.Entity.User;
import com.posSeystem.PosSystem.Security.JwtUtils;

@RestController
@CrossOrigin(origins = ("*"))
public class AuthController {

    // @Autowired
    // private userRepostory userrepostory;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/auth/login")
    public String login(@RequestBody User user) {
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken  = jwtUtils.generateJwtToken(authentication);

        System.out.println(jwtToken);

        return jwtToken;

    }
    
}
