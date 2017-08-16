package com.ritchey.edusys.web.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/14.
 * 系统登录用户信息
 */
public class Users implements java.io.Serializable{

    private Long id;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //创建时间
    private Date createTime;
    //最后登录时间
    private Date endLoginTime;
    //档案
    private Long personDocu;

    //无参构造器
    public Users(){}
    //根据用户名密码构造用户
    public Users(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
    //根据用户名密码 档案资料构造用户
    public Users(String userName,String password,Long personDocu){
        this.userName = userName;
        this.password = password;
        this.personDocu = personDocu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getEndLoginTime() {
        return endLoginTime;
    }

    public void setEndLoginTime(Date endLoginTime) {
        this.endLoginTime = endLoginTime;
    }

    public Long getPersonDocu() {
        return personDocu;
    }

    public void setPersonDocu(Long personDocu) {
        this.personDocu = personDocu;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", endLoginTime=" + endLoginTime +
                ", personDocu=" + personDocu +
                '}';
    }
}
