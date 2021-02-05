package com.letsgosportscards.letsGo_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email) {

       userService.updateUser(id, username, email);
    }

    @PostMapping(consumes = "application/json")
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }
}
