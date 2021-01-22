package com.yyou.tools.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private long id;
    private String name;
    private String password;
    private String description;
    private List<Role> roleList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    //region UserDetails Ctrl+Alt+T
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roleList;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }

    //账号过期标志
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }

    //锁定标志
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }

    //密码过期标志
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }

    //可用标志
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
    //endregion

}
