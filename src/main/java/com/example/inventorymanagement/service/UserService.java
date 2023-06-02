package com.example.inventorymanagement.service;


import com.example.inventorymanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
