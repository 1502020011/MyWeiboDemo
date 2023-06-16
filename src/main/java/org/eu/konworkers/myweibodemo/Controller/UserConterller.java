package org.eu.konworkers.myweibodemo.Controller;

import com.github.pagehelper.Page;
import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.MessageResult;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.domain.enties.UserResult;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.eu.konworkers.myweibodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/getuser")
    public UserResult getuser(Integer page){
        UserResult userresult = new UserResult();
        Page<User> page2 = userservice.getUserByPage(page);

        userresult.setData(page2.getResult());
        userresult.setTotal(page2.getTotal());
        userresult.setPages(page2.getPages());

        return userresult;
    }

    @RequestMapping("/deleteuser")
    public Result deleteuser(@RequestParam("id") String id, @RequestParam("username")String username){
        if("root".equals(username)){
            return new Result(false,MessageConstants.DELETE_ROOT_FAIL);
        }

        try{
            userservice.delete(id);
            return new Result(true,MessageConstants.USER_DELETE_SUCCESS);
        }catch (Exception e){
            return new Result(false,MessageConstants.USER_DELETE_FAIL);
        }
    }

    @RequestMapping("/setrole")
    public Result setrole(@RequestBody Map map){
        String id = (String) map.get("id");
        if ("23b01ead-2249-453b-be2f-b9349246fcde".equals(id)){
            return new Result(false,MessageConstants.EDITROLE_ROOT_FAIL);
        }
        String code = (String) map.get("code");

        try {
            userservice.setrole(id,code);
            return new Result(true,MessageConstants.ROLE_EDIT_SUCCESS);
        }catch (Exception e){
            return new Result(false,MessageConstants.ROLE_EDIT_FAIL);
        }
    }

}
