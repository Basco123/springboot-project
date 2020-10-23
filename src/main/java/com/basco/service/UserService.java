package com.basco.service;

import com.basco.pojo.User;

public interface UserService {
    User checkUser(String username,String password);
}
