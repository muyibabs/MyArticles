package com.muyi.user.controller;

import com.muyi.model.exception.NotFoundException;
import com.muyi.model.user.User;
import com.muyi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        User user = userService.getUserById(userId);
        if(user==null)
            throw new NotFoundException("101", "User with id: " + userId + " not found");
        return user;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.saveUser(user);
    }
}
