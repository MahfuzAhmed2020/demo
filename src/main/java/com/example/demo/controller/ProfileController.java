package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfileController {

    @Autowired
    private UserRepository userRepo;

    @PatchMapping("/update-profile/{id}")
    public Map<String,Object> updateProfile(@PathVariable Long id, @RequestBody Map<String,String> data){
        User user = userRepo.findById(id).orElseThrow();
        user.setFirstName(data.get("firstName"));
        user.setLastName(data.get("lastName"));
        user.setEmail(data.get("email"));

        if(data.get("newPassword") != null && !data.get("newPassword").isEmpty()){
            if(!user.getPassword().equals(data.get("oldPassword"))){
                return Map.of("success", false, "message", "Old password incorrect");
            }
            user.setPassword(data.get("newPassword"));
        }

        userRepo.save(user);
        return Map.of("success", true, "message", "Profile updated");
    }
}
