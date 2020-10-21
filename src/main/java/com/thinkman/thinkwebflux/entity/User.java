package com.thinkman.thinkwebflux.entity;

//@Data

public class User {
    private Long id;
    private String name;
    private String password;

    public User(Long nId, String szName, String szPwd) {
        this.id = nId;
        this.name = szName;
        this.password = szPwd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
