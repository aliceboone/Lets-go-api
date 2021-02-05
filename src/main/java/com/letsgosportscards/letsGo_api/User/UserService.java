package com.letsgosportscards.letsGo_api.User;

import com.letsgosportscards.letsGo_api.Role.Role;
import com.letsgosportscards.letsGo_api.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user, Long roleId) {
        Role role = roleRepository
                .findById(roleId)
                .orElseThrow(() -> new IllegalStateException("Role does not exists"));
        Optional<User> userOptional = userRepository
                .findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw  new IllegalStateException("email taken");
        }
        user.setRole(role);
        userRepository.save(user);
    }
}
