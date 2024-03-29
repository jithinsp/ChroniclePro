package com.corner.chronicle.controller;

import com.corner.chronicle.dto.HelloResponse;
import com.corner.chronicle.entity.Users;
import com.corner.chronicle.service.AuthService;
import com.corner.chronicle.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AuthService authService;
    @GetMapping("/hi")
    public HelloResponse adminMsg(){
        return new HelloResponse("Welcome back admin");
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/profile")
    public ResponseEntity<Users> getProfile(){
        String username = authService.getCurrentLoggedInUser();
        Users user = userService.getUserByEmail(username);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        System.out.println("deleting"+userId);
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


}