/*package com.rob.voidshop.service;

import com.rob.voidshop.model.Role;
import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

// To implement login/authentication with Spring Security, we need to implement springs UserDetailsService interface
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username){

        // get user from persistent database
        User user = userRepository.findByUsername(username);

        // check if user exists
        if (user == null){
            throw new UsernameNotFoundException("User does not exist");
        }

        // if user exists, grant them authorities based on the roles they have
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // instantiate and return a new UserDetails object based on the username, password and authority
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
*/