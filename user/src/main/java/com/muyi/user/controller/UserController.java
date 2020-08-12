package com.muyi.user.controller;

import com.muyi.model.exception.BadRequestException;
import com.muyi.model.exception.ConflictException;
import com.muyi.model.exception.NotFoundException;
import com.muyi.model.user.User;
import com.muyi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        System.out.println("======================== inside getUserById()");
        if(userId==null || userId<1)
            throw new BadRequestException("100","Invalid id");
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
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user){
//        User user1 = userService.getUserById(user.getUserId());
//        if(user1!=null)
//            throw new ConflictException("100", "User already exist");
        userService.saveUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user){
        User user1 = userService.getUserById(user.getUserId());
        if(user1==null)
            throw new NotFoundException("100", "User does not exist");
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(name = "id") Integer userId){
        if(userId==null || userId<1)
            throw new BadRequestException("100", "Invalid User id");
        User user = userService.getUserById(userId);
        if(user==null)
            throw new NotFoundException("100", "User does not exist");
        userService.deleteUser(user);
    }
}
