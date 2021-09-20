package com.miu.springbootproject.controller;

import com.miu.springbootproject.model.AuthenticationResponse;
import com.miu.springbootproject.model.Login;
import com.miu.springbootproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="http://localhost:3000")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping
    public AuthenticationResponse login(@RequestBody Login login){
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword(), new ArrayList<>()));
        if (authentication != null) {
            return new AuthenticationResponse("success", "Login Success", jwtUtil.generateToken(authentication));
        }
        return new AuthenticationResponse("failure", "Authentication failed", null);
    }




}
