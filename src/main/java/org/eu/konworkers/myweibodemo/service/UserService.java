package org.eu.konworkers.myweibodemo.service;

import com.github.pagehelper.Page;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.domain.pojo.Message;
import org.eu.konworkers.myweibodemo.domain.pojo.User;

public interface UserService {
    public void register(String username,String password,String nickname,String email);

    public boolean usernameIsExist(String username);

    public User selectByUsername(String username);

    public void edit(User user);

    //public boolean passwordchecker(String id,String oldpassword);

    public Result editpassword(String id, String oldpassword, String password);

    public Page<User> getUserByPage(Integer page);

    public void delete(String id);
}
