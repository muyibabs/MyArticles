package com.muyi.user.service;

import com.muyi.model.user.User;
import com.muyi.user.dao.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserDao userDao) {
        this.modelMapper = modelMapper;
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<com.muyi.model.user.entity.User> optUsr = userDao.findById(userId);
        if(optUsr.isPresent())
            return modelMapper.map(optUsr.get(), User.class);
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<com.muyi.model.user.entity.User> all = userDao.findAll();
        if(!all.isEmpty())
            return all.stream().map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
        return new ArrayList<User>();
    }

    @Override
    public void saveUser(User user) {
        com.muyi.model.user.entity.User eUser = modelMapper.map(user, com.muyi.model.user.entity.User.class);
        userDao.save(eUser);
    }

    @Override
    public void deleteUser(User user) {
        com.muyi.model.user.entity.User user1 = modelMapper.map(user, com.muyi.model.user.entity.User.class);
        userDao.delete(user1);
    }
}
