package org.eu.konworkers.myweibodemo.service.impl;

import org.eu.konworkers.myweibodemo.dao.RoleDao;
import org.eu.konworkers.myweibodemo.domain.pojo.Role;
import org.eu.konworkers.myweibodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> seleteAll() {
        return roleDao.seleteAll();
    }

    @Override
    public Role seleteByCode(String code) {
        return roleDao.seleteByCode(code);
    }
}
