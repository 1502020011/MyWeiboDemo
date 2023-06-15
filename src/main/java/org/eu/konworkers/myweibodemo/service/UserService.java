package org.eu.konworkers.myweibodemo.service;

import org.eu.konworkers.myweibodemo.domain.pojo.User;

public interface UserService {
    public void register(String username,String password,String nickname,String email);

    public boolean usernameIsExist(String username);

    public User selectByUsername(String username);

    public void edit(User user);
}
