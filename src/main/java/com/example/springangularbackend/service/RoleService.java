package com.example.springangularbackend.service;

import com.example.springangularbackend.dto.RoleDTO;
import com.example.springangularbackend.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {


    public List<Role> getAllRoles();
    Optional<Role> getById(int id);

    public Role addRole(RoleDTO roleDTO);

}
