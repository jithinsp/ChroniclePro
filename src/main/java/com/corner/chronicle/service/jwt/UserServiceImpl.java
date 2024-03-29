package com.corner.chronicle.service.jwt;

import com.corner.chronicle.entity.Users;
import com.corner.chronicle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users =
                userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(
                        "User not found with email: "+email));
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(users.getRole().getRoleName()));

        return new User(users.getEmail(), users.getPassword(), authorities);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
