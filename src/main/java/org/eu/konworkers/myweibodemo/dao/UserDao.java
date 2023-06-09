package org.eu.konworkers.myweibodemo.dao;

import org.eu.konworkers.myweibodemo.domain.pojo.User;

import java.util.List;

public interface UserDao {

    public void add();

    public void delete();

    public void edit(User user);

    public List<User> seleteAll();

    public User seleteByid(String id);
}
