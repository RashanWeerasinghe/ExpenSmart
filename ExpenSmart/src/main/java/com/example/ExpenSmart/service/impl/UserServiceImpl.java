package com.example.ExpenSmart.service.impl;

import com.example.ExpenSmart.Exception.ItemExistsException;
import com.example.ExpenSmart.entity.User;
import com.example.ExpenSmart.entity.UserModel;
import com.example.ExpenSmart.repo.UserRepository;
import com.example.ExpenSmart.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(UserModel user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new ItemExistsException("User is already register with email:"+user.getEmail());
        }
        User newUser=new User();
        BeanUtils.copyProperties(user,newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }
}
