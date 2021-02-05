package com.letsgosportscards.letsGo_api.User;

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

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "/role/{roleId}",  consumes = "application/json")
    public void registerNewUser(@PathVariable("roleId") Long roleId,  @RequestBody User user) {
        userService.addNewUser(user, roleId);
    }
}
