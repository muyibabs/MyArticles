package com.muyi.user.controller;

import com.muyi.model.user.User;
import com.muyi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Integer userId){
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }


}
