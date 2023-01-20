package com.example.website.website.api;

import com.example.website.website.entity.User;
import com.example.website.website.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private LoginService loginService;

    @GetMapping("/user")
    public List<User> index() {
        return this.loginService.findAll();
    }
    @PostMapping("/user/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        /*this.loginService.addUser(user);*/
        return user;
    }
}
