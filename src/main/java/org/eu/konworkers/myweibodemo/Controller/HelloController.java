package org.eu.konworkers.myweibodemo.Controller;


import org.eu.konworkers.myweibodemo.domain.pojo.Role;
import org.eu.konworkers.myweibodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/roledaotest")
    public List<Role> role(String code) {
        if (code == null) {
            return roleService.selectAll();
        } else {
            ArrayList<Role> role = new ArrayList<>();
            role.add(roleService.selectByCode(code));
            return role;
        }
    }

    @RequestMapping("/datetest")
    public Date datetest() {
        return new Date();
    }
}