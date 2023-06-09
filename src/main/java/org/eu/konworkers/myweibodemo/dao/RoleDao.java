package org.eu.konworkers.myweibodemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.eu.konworkers.myweibodemo.domain.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface RoleDao {

    public List<Role> seleteAll();

    public Role seleteByCode(String code);

}
