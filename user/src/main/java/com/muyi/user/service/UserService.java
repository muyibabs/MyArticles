package com.muyi.user.service;

import com.muyi.model.user.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer userId);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(User user);
}
