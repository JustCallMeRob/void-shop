package com.rob.voidshop.service;

import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUsers(String username){
        return userRepository.findByUsername(username);
    }

    public void updateUsers(User user) {
        userRepository.save(user);
    }

}
