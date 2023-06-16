package org.eu.konworkers.myweibodemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.eu.konworkers.myweibodemo.dao.MessageDao;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class MessageServiceimpl implements MessageService {

    @Autowired
    private MessageDao messagedao;
    @Override
    public Page<Message> getMessageByPage(Integer page) {
        PageHelper.startPage(page,5);
        Page<Message> page2 = messagedao.selectBypage();
        return page2;
    }

    @Override
    public void sendMessage(String id, String message) {
        Message message1 = new Message();

        message1.setId(UUID.randomUUID().toString());
        message1.setMessage(message);
        message1.setUser_Id(id);
        message1.setCreatedTime(new Date());

        messagedao.add(message1);
    }

    @Override
    public void delete(String id) {
        messagedao.delete(id);
    }
}
