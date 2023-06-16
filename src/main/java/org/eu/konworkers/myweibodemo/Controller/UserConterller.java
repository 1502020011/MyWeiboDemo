package org.eu.konworkers.myweibodemo.Controller;

import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.eu.konworkers.myweibodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @RequestMapping("/edit")
    public Result edit(@RequestBody Map map){
        String nickname = (String) map.get("nickname");
        String email = (String) map.get("email");
        String iconAddress = (String) map.get("iconAddress");

        UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user2 = userdetails.getUsername();
        User user3 = userservice.selectByUsername(user2);
        String id = user3.getId();

        User user = new User();
        user.setId(id);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setIconAddress(iconAddress);

        try{
            userservice.edit(user);
            return new Result(true,MessageConstants.USER_EDIT_SUCCESS);
        }catch (Exception e){
            return new Result(true,MessageConstants.USER_EDIT_FAIL);
        }
    }

    @RequestMapping("/editpassword")
    public Result editpassword(@RequestBody Map map){
        String password = (String) map.get("password");
        String password2 = (String) map.get("password2");
        if(!password.equals(password2)){
            return new Result(false, MessageConstants.EDIT_PASSWORDNOTMATCH_FAIL);
        }

        String oldpassword = (String) map.get("oldpassword");
        UserDetails userdetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user2 = userdetails.getUsername();
        User user3 = userservice.selectByUsername(user2);
        String id = user3.getId();

        Result passwordresult = userservice.editpassword(id, oldpassword, password);

        return passwordresult;
    }

}
