package com.letsgosportscards.letsGo_api.Role;

import com.letsgosportscards.letsGo_api.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void addNewRole(Role role) {
        Optional<Role> userOptional = roleRepository
                .findByName(role.getName());
        if (userOptional.isPresent()) {
            throw  new IllegalStateException("email taken");
        }
        roleRepository.save(role);
    }
}
