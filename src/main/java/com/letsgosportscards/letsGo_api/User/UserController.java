package com.letsgosportscards.letsGo_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
