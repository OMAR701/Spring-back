package com.example.springangularbackend.service.impl;


import com.example.springangularbackend.dto.RoleDTO;
import com.example.springangularbackend.model.Role;
import com.example.springangularbackend.repository.RoleRepository;
import com.example.springangularbackend.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(int id) {
        return Optional.ofNullable(roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("There's no role with id %s", id))));
    }


    @Override
    public Role addRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        return roleRepository.save(role);

    }
}
