package com.example.examserver.service;


import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import com.example.examserver.repo.RoleRepository;
import com.example.examserver.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //for creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local !=null){
            System.out.println("User is already there!!");
            throw new Exception("User already present !!");
        }
        else
        {
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.setUserRoles(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
}
