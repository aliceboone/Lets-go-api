package com.letsgosportscards.letsGo_api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Username taken");
        }
        userRepository.save(user);
    }

    public User showUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with ID: " + userId + " does not exist"
                ));
        return user;
    }

    public User showByUserName(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException(
                        "User with userName: " + username + " does not exist"
                ));
        return user;
    }
}


