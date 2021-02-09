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

    public static void deleteUser(Long userId, User user) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException(
                    "user with id" + userId + "does not exist");
        }
        userRepository.deleteUser(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User showUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with ID: " + userId + " does not exist"
                ));
        return user;
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }
        userRepository.save(user);
    }

    public void updateUser(Long userId, User user) {
        User checkUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + userId + " does not exists"
                ));
        checkUser.setEmail(user.getEmail());
        userRepository.save( checkUser);
    }

}


