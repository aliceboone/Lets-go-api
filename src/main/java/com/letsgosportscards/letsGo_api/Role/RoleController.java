package com.letsgosportscards.letsGo_api.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getUsers() {
        return roleService.getRoles();
    }

    @PostMapping(consumes = "application/json")
    public void registerNewRole(@RequestBody Role role) {
        roleService.addNewRole(role);
    }

}
