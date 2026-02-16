package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Address;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserDataController {

    private final CardRepository cardRepo;
    private final AddressRepository addressRepo;

    public UserDataController(CardRepository cardRepo, AddressRepository addressRepo) {
        this.cardRepo = cardRepo;
        this.addressRepo = addressRepo;
    }

    @GetMapping("/cards/{userId}")
    public List<Card> getCards(@PathVariable Long userId) {
        return cardRepo.findByUserId(userId);
    }

    @GetMapping("/addresses/{userId}")
    public List<Address> getAddresses(@PathVariable Long userId) {
        return addressRepo.findByUserId(userId);
    }
}
