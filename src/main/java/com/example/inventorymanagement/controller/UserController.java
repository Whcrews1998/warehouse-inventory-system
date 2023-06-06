package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.User;
import com.example.inventorymanagement.exception.UserNotFoundException;
import com.example.inventorymanagement.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUser(@RequestParam("username") String userName, @RequestParam("password") String password) {
        User user = userService.findByUsernameAndPassword(userName, password);
        if (user == null) throw new UserNotFoundException("User Not Found");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/users/create-user")
    public ResponseEntity<User> createUser(@RequestBody User userDetails) {
        userService.save(userDetails);
        return new ResponseEntity<User>(userDetails, HttpStatus.OK);
    }
}
