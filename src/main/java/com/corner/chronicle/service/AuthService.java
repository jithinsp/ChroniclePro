package com.corner.chronicle.service;


import com.corner.chronicle.dto.SignupRequest;
import com.corner.chronicle.entity.Users;

public interface AuthService {
    Users createUser(SignupRequest signupRequest);
    public String getCurrentLoggedInUser();
}
