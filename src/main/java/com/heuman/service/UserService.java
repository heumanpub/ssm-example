package com.heuman.service;

import com.heuman.domain.User;
import com.heuman.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by heuman on 2017/12/20.
 */
@Service
public class UserService {

    private final transient Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User findByUsernamePassword(User user) {
        return userMapper.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
