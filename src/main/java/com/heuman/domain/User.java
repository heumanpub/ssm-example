package com.heuman.domain;

import com.heuman.common.enums.Role;

/**
 * Created by heuman on 2017/12/20.
 */
public class User extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String password;
    private Role role;
    private Boolean locked;
    private Boolean enable;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
