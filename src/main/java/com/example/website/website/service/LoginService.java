package com.example.website.website.service;

import com.example.website.website.entity.User;
import com.example.website.website.repository.RoleRepo;
import com.example.website.website.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public User findUserByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }
    public void addUser(User user) {
        this.userRepo.save(user);
    }

    public List<User> findAll() {
        return this.userRepo.findAll();
    }
}
