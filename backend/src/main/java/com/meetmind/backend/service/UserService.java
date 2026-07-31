package com.meetmind.backend.service;
import com.meetmind.backend.dto.RegisterRequest;
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

    public void registerUser(RegisterRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
    @Autowired
    private PasswordEncoder passwordEncoder;

}