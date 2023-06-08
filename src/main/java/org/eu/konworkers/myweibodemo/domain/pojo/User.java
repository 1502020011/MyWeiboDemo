package org.eu.konworkers.myweibodemo.domain.pojo;

import javax.validation.constraints.Email;
import java.util.Date;

public class User {
    private String id;
    private String name;
    private String password;
    private Date cratedTime;
    private String nickname;

    @Email(message = "请正确输入邮箱")
    private String email;
    private String roleId;
    private String iconAddress;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCratedTime() {
        return cratedTime;
    }

    public void setCratedTime(Date cratedTime) {
        this.cratedTime = cratedTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }
}
