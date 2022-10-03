package com.evaluation.me.controller;

import com.evaluation.me.entity.User;
import com.evaluation.me.service.UserService;
import com.evaluation.me.validators.EmailValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserController {


    private UserService userService;


    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        return ResponseEntity.ok().body(userService.addUser(user));

    }



}
