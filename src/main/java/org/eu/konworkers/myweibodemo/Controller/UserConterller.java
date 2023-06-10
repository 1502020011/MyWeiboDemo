package org.eu.konworkers.myweibodemo.Controller;

import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserConterller {

    @Autowired
    private UserService userservice;

    @RequestMapping("/register")
    public Result register(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        String password2 = (String) map.get("password2");
        String nickname = (String) map.get("nickname");
        String email = (String) map.get("email");

        if(!password.equals(password2)){
            return new Result(false, MessageConstants.REGISTER_PASSWORDNOTMATCH_FAIL);
        }

        if(userservice.usernameIsExist(username)){
            return new Result(false, MessageConstants.REGISTER_USERNAMEISEXIST_FAIL);
        }

        try{
            userservice.register(username,password,nickname,email);
            return new Result(true,MessageConstants.REGISTER_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstants.REGISTER_FAIL);
        }

    }

}
