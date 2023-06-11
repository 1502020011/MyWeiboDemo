package org.eu.konworkers.myweibodemo.Controller;


import com.github.pagehelper.Page;
import org.eu.konworkers.myweibodemo.domain.enties.MessageResult;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageservice;

    @RequestMapping("/getmessage")
    public MessageResult getMessage(Integer page){
        MessageResult messageresult = new MessageResult();
        Page<Message> page2 = messageservice.getMessageByPage(page);

        messageresult.setData(page2.getResult());
        messageresult.setTotal(page2.getTotal());
        messageresult.setPages(page2.getPages());

        return messageresult;
    }
}
