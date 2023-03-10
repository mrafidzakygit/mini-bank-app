package com.example.website.website.service;

import com.example.website.website.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.website.website.entity.User userApp= this.loginService.findUserByUsername(username);
        List<GrantedAuthority> auths = new ArrayList<>();

        if (userApp != null) {
            List<Role> roles = userApp.getRoles();
            if (roles.size() > 0) {
                for (Role role : roles) {
                    auths.add(new SimpleGrantedAuthority(role.getRole()));
                    auths.add(new SimpleGrantedAuthority(role.getRole()));
                    auths.add(new SimpleGrantedAuthority(role.getRole()));
                }
            }
            UserDetails user = User.withUsername(userApp.getUsername())
                    .password(userApp.getPassword())
                    .authorities(auths)
                    .build();
            return user;
        } else {
            throw new UsernameNotFoundException("User not found");
        }

    }
}
