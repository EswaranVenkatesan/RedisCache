package com.app.user.repository;

import com.app.user.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public static final String KEY = "USER";

    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepository(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    /*Getting a specific user details by user id from table*/
    public User getUser(int userId){
        return (User) hashOperations.get(KEY,userId);
    }

    /*Adding an user into redis database*/
    public void addUser(User user){
        hashOperations.put(KEY,user.getUserId(),user);
    }
}
