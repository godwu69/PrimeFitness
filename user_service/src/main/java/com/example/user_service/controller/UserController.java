package com.example.user_service.controller;

import com.example.user_service.dto.LoginRequest;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserService;
import com.example.user_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        System.out.println(email);
        System.out.println(password);

        // Tìm người dùng theo email
        UserDetails user = userService.loadUserByUsername(email);

        // Kiểm tra nếu người dùng tồn tại và mật khẩu đúng
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Tạo và trả về token JWT
            String token = jwtUtil.generateToken(email);
            return ResponseEntity.ok(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already in use");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Register successfully");
    }
}
