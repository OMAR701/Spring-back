package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RoleRepository extends JpaRepository<Role, Integer> {
}