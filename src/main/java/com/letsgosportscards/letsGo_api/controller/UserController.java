package com.letsgosportscards.letsGo_api.controller;

import com.letsgosportscards.letsGo_api.User.UserRepository;
import com.letsgosportscards.letsGo_api.User.UserService;
import com.letsgosportscards.letsGo_api.model.User;
import com.letsgosportscards.letsGo_api.exception.ResourceNotFoundException;
import com.letsgosportscards.letsGo_api.security.CurrentUser;
import com.letsgosportscards.letsGo_api.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    private final  UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    // Update
    @PutMapping(path = "/{userId}")
    public void updateUser(@CurrentUser UserPrincipal userPrincipal, @PathVariable long userId,
                              @RequestBody User user) {
        userService.updateUser(userId,user);

    }

}