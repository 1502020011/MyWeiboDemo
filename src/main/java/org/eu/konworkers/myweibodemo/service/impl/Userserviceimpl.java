package org.eu.konworkers.myweibodemo.service.impl;

import org.eu.konworkers.myweibodemo.dao.UserDao;
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
}
