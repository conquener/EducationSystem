package com.ritchey.edusys.web.model;

import java.util.Date;

public class Users {
    private Long id;

    private String userName;

    private String userPwd;

    private Date createTime;

    private Date endLoginTime;

    private Long persionDocu;

    private Integer valid;

    public Users(String userName,String userPwd){
        this.userName = userName;
        this.userPwd = userPwd;
    }
    public Users(){}

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndLoginTime() {
        return endLoginTime;
    }

    public void setEndLoginTime(Date endLoginTime) {
        this.endLoginTime = endLoginTime;
    }

    public Long getPersionDocu() {
        return persionDocu;
    }

    public void setPersionDocu(Long persionDocu) {
        this.persionDocu = persionDocu;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}