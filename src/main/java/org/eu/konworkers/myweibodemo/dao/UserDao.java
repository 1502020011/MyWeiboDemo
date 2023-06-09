package org.eu.konworkers.myweibodemo.dao;

import org.eu.konworkers.myweibodemo.domain.pojo.User;

import java.util.List;

public interface UserDao {

    public void add();

    public void deleteById(String id);

    public void editBasicData(User user);

    public List<User> selectAll();

    public User selectById(String id);
}
