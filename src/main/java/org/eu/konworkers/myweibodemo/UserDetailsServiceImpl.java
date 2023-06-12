package org.eu.konworkers.myweibodemo;

import org.eu.konworkers.myweibodemo.dao.RoleDao;
import org.eu.konworkers.myweibodemo.dao.UserDao;
import org.eu.konworkers.myweibodemo.domain.pojo.Role;
import org.eu.konworkers.myweibodemo.domain.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private RoleDao roledao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userdao.selectByUsername(username);
        if (user == null){
            return null;
        }
        String username2 = user.getUsername();
        String password2 = user.getPassword();
        String roleid = user.getRoleId();

        Role role = roledao.selectById(roleid);
        String code = role.getCode();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(code));

        org.springframework.security.core.userdetails.User user2 = new org.springframework.security.core.userdetails.User(username2,password2,authorities);
        return user2;
    }
}
