package com.example.ExpenSmart.controller;


import com.example.ExpenSmart.entity.User;
import com.example.ExpenSmart.entity.UserModel;
import com.example.ExpenSmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
        System.out.println("test");
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
