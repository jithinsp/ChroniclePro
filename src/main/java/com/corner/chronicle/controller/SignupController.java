package com.corner.chronicle.controller;

import com.corner.chronicle.dto.SignupRequest;
import com.corner.chronicle.entity.Users;
import com.corner.chronicle.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        Users user = authService.createUser(signupRequest);
        if (user != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }
    }

//    @PostMapping
//    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
//        boolean isUserCreated = authService.createUser(signupRequest);
//        if (isUserCreated){
//            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
//        }
//    }
}
