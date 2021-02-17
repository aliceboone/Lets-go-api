package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Product.ProductService;
import com.letsgosportscards.letsGo_api.model.User;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductService productService;

    public UserService(UserRepository userRepository, ProductService productService) {
        this.userRepository = userRepository;
        this.productService = productService;
    }

    // Update
    @Transactional
    public void updateUser(long userId, User user) {
        User checkUser = userRepository
                .findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exists"));
        user.setName(checkUser.getName());
        user.setEmail(checkUser.getEmail());
        user.setImageUrl(checkUser.getImageUrl());
        userRepository.save(checkUser);
    }
}
