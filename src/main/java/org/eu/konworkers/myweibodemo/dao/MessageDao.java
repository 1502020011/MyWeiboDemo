package org.eu.konworkers.myweibodemo.dao;


import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MessageDao {
    public Page<Message> selectBypage();

    public void add(Message message);
}
