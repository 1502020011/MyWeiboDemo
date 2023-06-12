package org.eu.konworkers.myweibodemo.Controller;


import net.sf.jsqlparser.expression.operators.relational.OldOracleJoinBinaryExpression;
import org.eu.konworkers.myweibodemo.dao.UserDao;
import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationmanager;

    @Autowired
    private UserDao userdao;

    @RequestMapping ("/auth")
    public Result login(@RequestBody Map map){
        String username = (String)map.get("username");
        String password = (String)map.get("password");
        try {
            Authentication authentication = authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new Result(true, MessageConstants.LOGIN_SUCCESS);
        }catch (AuthenticationException e) {
            return new Result(false, MessageConstants.LOGIN_FAIL);
        }
    }

    @RequestMapping("/getloggedin")
    public Result loggedin(){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) user;
            String user2 = userDetails.getUsername();

            User user3 = userdao.selectByUsername(user2);
            return new Result(true,MessageConstants.LOGIN_GETLOGGEDIN_SUCCESS,user3);
        } else if (user instanceof String) {
            String username = (String) user;
            if("anonymousUser".equals(username)){
                return new Result(false,MessageConstants.LOGIN_GETLOGGEDIN_FAIL);
            }
        }

        return new Result(false,"未知错误");
    }
}
