package com.ritchey.edusys.web.model;

import java.util.Date;

public class Users {
    private Long id;

    private String username;

    private String password;

    private Date createtime;

    private Date endlogintime;

    private Long persondocu;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndlogintime() {
        return endlogintime;
    }

    public void setEndlogintime(Date endlogintime) {
        this.endlogintime = endlogintime;
    }

    public Long getPersondocu() {
        return persondocu;
    }

    public void setPersondocu(Long persondocu) {
        this.persondocu = persondocu;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}