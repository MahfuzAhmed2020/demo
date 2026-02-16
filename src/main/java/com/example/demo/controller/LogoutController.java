package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LogoutController {

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // If you are using sessions, you could invalidate them here.
        // request.getSession().invalidate();

        return ResponseEntity.ok(
            java.util.Map.of(
                "success", true,
                "message", "Logged out successfully"
            )
        );
    }
}
