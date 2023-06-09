package org.eu.konworkers.myweibodemo.Controller;

import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserConterller {

    @RequestMapping("/register")
    public Result register(@RequestBody String username ,@RequestBody String password ,@RequestBody String password2 ,@RequestBody String nickname ,@RequestBody String email){
        System.out.println(username+" "+password+" "+password2+" "+nickname+" "+email);
        return new Result(false,"访问成功");
    }
}
