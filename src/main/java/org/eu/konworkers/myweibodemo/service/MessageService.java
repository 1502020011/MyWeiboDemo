package org.eu.konworkers.myweibodemo.service;

import com.github.pagehelper.Page;
import io.swagger.models.auth.In;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;

public interface MessageService {
    public Page<Message> getMessageByPage(Integer page);

    public void sendMessage(String id,String message);

    public void delete(String id);
}
