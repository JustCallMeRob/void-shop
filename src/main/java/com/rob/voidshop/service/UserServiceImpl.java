/*package com.rob.voidshop.service;

import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.RoleRepository;
import com.rob.voidshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        // encrypt user password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // assign user roles
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        // save to persistent data source
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}*/