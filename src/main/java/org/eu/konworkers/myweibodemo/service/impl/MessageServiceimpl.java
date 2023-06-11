package org.eu.konworkers.myweibodemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.eu.konworkers.myweibodemo.dao.MessageDao;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
