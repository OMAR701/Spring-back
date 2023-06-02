package com.example.springangularbackend.graphql;

import com.example.springangularbackend.dto.RoleDTO;
import com.example.springangularbackend.expceptions.GraphQlExceptionHandler;
import com.example.springangularbackend.model.Role;
import com.example.springangularbackend.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Controller
public class RoleGraphQl  {


    @Autowired
    private final RoleServiceImpl roleService;

    @Autowired
    public RoleGraphQl(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @QueryMapping
    public Optional<Role> getRole(@Argument int id) {
        return Optional.ofNullable(roleService.getById(id)
                .orElseThrow(() -> new RuntimeException(String.format("There's no role with id %s", id))));
    }


    @QueryMapping
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @MutationMapping
    public Role addRole(@Argument RoleDTO roleDTO){
        return roleService.addRole(roleDTO);

    }
}
