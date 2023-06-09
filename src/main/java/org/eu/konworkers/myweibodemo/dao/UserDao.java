package org.eu.konworkers.myweibodemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    public void add(User user);

    public void deleteById(String id);

    public void editBasicData(User user);

    public List<User> selectAll();

    public User selectById(String id);
}
