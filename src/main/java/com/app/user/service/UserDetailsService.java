package com.app.user.service;

import com.app.user.model.User;
import com.app.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value="usercache", key="#userId", unless = "#result.userId>103")
    public User getUserDetailsById(int userId) {
        logger.info("Call request to Database");

        User userDetails = userRepository.getUser(userId);

        logger.info("Call response from Database --> {}", userDetails);
        return userDetails;
    }

    //@CachePut(value="usercache",key = "#userId")
    public void addUser(User user) {
        logger.info("Call request to Database for updating the user request {}", user);
        userRepository.addUser(user);
    }
}
