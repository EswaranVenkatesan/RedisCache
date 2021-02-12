package com.app.user.controller;

import com.app.user.model.User;
import com.app.user.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(value = "/student/details/get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetails(@PathVariable int userId) {
        long startTime = System.currentTimeMillis();
        User responseObj = userDetailsService.getUserDetailsById(userId);
        return new ResponseEntity<User>(responseObj, HttpStatus.OK);
    }

    @PostMapping(value = "/student/details/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userDetailsService.addUser(user);
        return new ResponseEntity<>("Successfully Updated the user details", HttpStatus.OK);
    }
}
