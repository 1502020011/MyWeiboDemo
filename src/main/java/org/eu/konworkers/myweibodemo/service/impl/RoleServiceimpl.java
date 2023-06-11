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
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public Role selectByCode(String code) {
        return roleDao.selectByCode(code);
    }

    @Override
    public Role selectById(String id) {
        return roleDao.selectById(id);
    }
}
