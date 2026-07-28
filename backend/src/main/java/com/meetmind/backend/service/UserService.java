package com.meetmind.backend.service;

import org.springframework.stereotype.Service;
import com.meetmind.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.meetmind.backend.entity.User;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
    @Autowired
    private PasswordEncoder passwordEncoder;

}