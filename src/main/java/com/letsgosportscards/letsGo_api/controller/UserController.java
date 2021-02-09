package com.letsgosportscards.letsGo_api.controller;

import com.letsgosportscards.letsGo_api.User.UserRepository;
import com.letsgosportscards.letsGo_api.model.User;
import com.letsgosportscards.letsGo_api.exception.ResourceNotFoundException;
import com.letsgosportscards.letsGo_api.security.CurrentUser;
import com.letsgosportscards.letsGo_api.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}