package org.eu.konworkers.myweibodemo.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    public void add(User user);

    public void deleteById(String id);

    public void editBasicData(User user);

    public Page<User> selectAll();

    public User selectById(String id);

    public User selectByUsername(String username);

    public void editpassword(User user);

    public void setrole(User user);

}
