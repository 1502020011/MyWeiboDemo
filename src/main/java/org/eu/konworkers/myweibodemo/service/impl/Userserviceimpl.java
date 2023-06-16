package org.eu.konworkers.myweibodemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.eu.konworkers.myweibodemo.dao.UserDao;
import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.eu.konworkers.myweibodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class Userserviceimpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(String username, String password, String nickname, String email) {
        User user = new User();

        user.setId(UUID.randomUUID().toString());

        user.setUsername(username);

        user.setPassword(passwordEncoder.encode(password));

        user.setCratedTime(new Date());

        user.setNickname(nickname);

        user.setEmail(email);

        user.setRoleId("5c8616e2-0a1a-444c-993f-e25a88b09325");

        user.setIconAddress("https://raw.githubusercontent.com/1502020011/MyWeiboDemoImageRepository/main/104785358_p0_master1200.jpg");

        userdao.add(user);
    }

    @Override
    public boolean usernameIsExist(String username) {
        boolean flag = false;

        User user = userdao.selectByUsername(username);

        if(user != null){
            flag = true;
        }
        return flag;
    }

    @Override
    public User selectByUsername(String username) {
        return userdao.selectByUsername(username);
    }

    @Override
    public void edit(User user) {
        userdao.editBasicData(user);
    }

//    @Override
//    public boolean passwordchecker(String id, String oldpassword) {
//        User user = userdao.selectById(id);
//        String oldpasswordencode = passwordEncoder.encode(oldpassword);
//        String password = user.getPassword();
//
//        System.out.println(oldpasswordencode);
//        System.out.println(password);
//
//        if(oldpasswordencode.equals(password)){
//            return true;
//        }else {
//            return false;
//        }
//    }

    @Override
    public Result editpassword(String id, String oldpassword , String password) {
        User user = userdao.selectById(id);
        String dbpassword = user.getPassword();

        if(passwordEncoder.matches(oldpassword,dbpassword)) {
            User user1 = new User();
            user1.setId(id);
            user1.setPassword(passwordEncoder.encode(password));
            try{
                userdao.editpassword(user1);
                return new Result(true, MessageConstants.EDIT_PASSWORD_SUCCESS);
            }catch (Exception e){
                return new Result(false, MessageConstants.EDIT_PASSWORD_FAIL);
            }
        }else {
            return new Result(false, MessageConstants.EDIT_PASSWORDNOTMATCH_FAIL);
        }
    }

    @Override
    public Page<User> getUserByPage(Integer page) {
        PageHelper.startPage(page,5);
        Page<User> page2 = userdao.selectAll();
        return page2;
    }

    @Override
    public void delete(String id) {
        userdao.deleteById(id);
    }
}
