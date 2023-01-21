package com.example.website.website.service;

import com.example.website.website.entity.Role;
import com.example.website.website.entity.User;
import com.example.website.website.repository.RoleRepo;
import com.example.website.website.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InitDefaultUserAuth {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void index() {
        //create role
        Role roleCs = new Role();
        Role roleAdmin = new Role();
        Role roleOp = new Role();

        roleOp.setRole("operator");
        roleCs.setRole("customerservice");
        roleAdmin.setRole("admin");
        this.roleRepo.save(roleCs);
        this.roleRepo.save(roleAdmin);
        this.roleRepo.save(roleOp);

        //create user
        List<Role> AdminRole = new ArrayList<>();
        AdminRole.add(roleAdmin);

        List<Role> CsRole = new ArrayList<>();
        CsRole.add(roleCs);

        List<Role> OpRole = new ArrayList<>();
        OpRole.add(roleOp);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setEmail("admin@gmail.com");
        userAdmin.setPassword(new BCryptPasswordEncoder().encode("1234"));
        userAdmin.setRoles(AdminRole);

        User userCS = new User();
        userCS.setUsername("customerservice");
        userCS.setEmail("cs@gmail.com");
        userCS.setPassword(new BCryptPasswordEncoder().encode("1234"));
        userCS.setRoles(CsRole);

        User userOp = new User();
        userOp.setUsername("operator");
        userOp.setEmail("op@gmail.com");
        userOp.setPassword(new BCryptPasswordEncoder().encode("1234"));
        userOp.setRoles(OpRole);

        this.userRepo.save(userAdmin);
        this.userRepo.save(userOp);
        this.userRepo.save(userCS);
    }
}
