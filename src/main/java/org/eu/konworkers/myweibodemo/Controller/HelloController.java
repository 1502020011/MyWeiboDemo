package org.eu.konworkers.myweibodemo.Controller;


import org.eu.konworkers.myweibodemo.domain.pojo.Role;
import org.eu.konworkers.myweibodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/roledaotest")
    public List<Role> role(){
        return roleService.seleteAll();
    }
}
