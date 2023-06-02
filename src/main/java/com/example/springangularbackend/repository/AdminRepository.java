package com.example.springangularbackend.repository;

import com.example.springangularbackend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
}
