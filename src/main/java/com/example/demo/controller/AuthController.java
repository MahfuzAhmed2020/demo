package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> data){
        User user = new User();
        user.setFirstName(data.get("firstName"));
        user.setLastName(data.get("lastName"));
        user.setEmail(data.get("email"));
        user.setPassword(data.get("password")); // hash in production

        userRepo.save(user);
        return ResponseEntity.ok(Map.of("success", true, "message", "Registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> data){
        String email = data.get("email");
        String password = data.get("password");

        User user = userRepo.findByEmail(email).orElse(null); // ✅ fixed
        if(user == null || !user.getPassword().equals(password)){
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Invalid email or password"));
        }

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Login successful",
                "user", Map.of(
                        "id", user.getId(),
                        "firstName", user.getFirstName(),
                        "lastName", user.getLastName(),
                        "email", user.getEmail()
                )
        ));
    }
}
