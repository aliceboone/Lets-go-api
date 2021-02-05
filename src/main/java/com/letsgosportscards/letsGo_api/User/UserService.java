package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Product.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw  new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void updateUser(Long id,
                           String username,
                           String email) {
       User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + id + " does not exists"
                ));
        if (username != null && username.length() > 0 ) {
            user.setUsername(username);
        }
        if (email != null && email .length() > 0 ) {
            user.setEmail(email);
        }
    }
}
