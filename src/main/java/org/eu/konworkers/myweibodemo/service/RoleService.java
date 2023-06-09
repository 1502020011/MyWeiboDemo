package org.eu.konworkers.myweibodemo.service;

import org.eu.konworkers.myweibodemo.domain.pojo.Role;

import java.util.List;

public interface RoleService {

    public List<Role> seleteAll();

    public Role seleteByCode(String code);
}
