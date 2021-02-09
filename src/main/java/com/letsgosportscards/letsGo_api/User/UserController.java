package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/user")

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

    // Show by Id
    @GetMapping(path = "{userId}")
    public User showUser(@PathVariable("userId") Long userId) {
        return userService.showUser(userId);
    }

    // Create
    @PostMapping(consumes = "application/json")
    public void addNewUser(@RequestBody User user) {
       userService.addNewUser(user);
    }

//    // Update
//    @PutMapping(path = "/{userId}")
//    public void updateUser(@PathVariable("userId") Long userId,
//                               @RequestBody User user) {
//       UserService.updateUser(userId, user);
//    }
//
//    //Delete
//    @DeleteMapping(path = "{categoryId}")
//    public void deleteUser(@PathVariable("userId") Long userId,
//                           @RequestBody User user) {
//        UserService. deleteUser(userId, user);
//    }
}
