package com.basco.service;

import com.basco.dao.UserRepository;
import com.basco.pojo.User;
import com.basco.utils.MD5utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5utils.code(password));
        return user;
    }
}
