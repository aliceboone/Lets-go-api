package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Index
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Show by ID
    @GetMapping(path = "{userId}")
    public User showUser(@PathVariable("userId") Long userId) {
        return userService.showUser(userId);
    }

    // Show by userName
    @GetMapping(path = "/userName")
    public User showUserByUserName(
            @RequestParam(required = true) String userName) {
        return userService.showByUserName(userName);
    }

    // Create
    @PostMapping(consumes = "application/json")
    public void addNewUser(@RequestBody User user) {
       userService.addNewUser(user);
    }

}
