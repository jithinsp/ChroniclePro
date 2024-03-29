package com.corner.chronicle.service.impl;

import com.corner.chronicle.dto.SignupRequest;
import com.corner.chronicle.entity.Role;
import com.corner.chronicle.entity.Users;
import com.corner.chronicle.repository.RoleRepository;
import com.corner.chronicle.repository.UserRepository;
import com.corner.chronicle.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    public String getCurrentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            // You can access other user details like authorities, etc., from userDetails
            return username;
        } else {
            return "No user is currently logged in";
        }
    }
    @Override
    public Users createUser(SignupRequest signupRequest) {
        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return null;
        }
        Optional<Role> userRoleOptional = roleRepository.findRoleByName("ROLE_ACCOUNTANT");
        Role userRole = userRoleOptional.orElseGet(()->{
            Role newRole = new Role();
            newRole.setRoleName("ROLE_ACCOUNTANT");
            return roleRepository.save(newRole);
        });
        Users users = new Users();
        BeanUtils.copyProperties(signupRequest, users); //instead of getting and setting we can use
        // this
        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        users.setPassword(hashedPassword);
        users.setRole(userRole);
        Users createdUser = userRepository.save(users);
        users.setId(createdUser.getId());
        return users;
    }
}
