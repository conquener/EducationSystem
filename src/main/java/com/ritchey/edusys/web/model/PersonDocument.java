package com.ritchey.edusys.web.model;

import java.util.Date;

/**
 * 个人档案
 * Created by Administrator on 2017/8/14.
 */
public class PersonDocument implements java.io.Serializable{

    private Long id;
    //中文姓名
    private String name_cn;
    //英文姓名
    private String name_en;
    //年龄
    private int age;
    //性别
    private int sex;
    //出生年月
    private Date birthday;
    //籍贯
    private String nativePlace;
    //出生地址
    private String bothPlace;
    //身份证
    private String idCard;
    //兴趣爱好
    private String insterestDesc;
    //入校时间
    private Date enterSchoolTime;
    //离校时间
    private Date leaveSchoolTime;
    //人员性质( teacher or student )
    private int personType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getBothPlace() {
        return bothPlace;
    }

    public void setBothPlace(String bothPlace) {
        this.bothPlace = bothPlace;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getInsterestDesc() {
        return insterestDesc;
    }


    public void setInsterestDesc(String insterestDesc) {
        this.insterestDesc = insterestDesc;
    }

    public Date getEnterSchoolTime() {
        return enterSchoolTime;
    }

    public void setEnterSchoolTime(Date enterSchoolTime) {
        this.enterSchoolTime = enterSchoolTime;
    }

    public Date getLeaveSchoolTime() {
        return leaveSchoolTime;
    }

    public void setLeaveSchoolTime(Date leaveSchoolTime) {
        this.leaveSchoolTime = leaveSchoolTime;
    }

    public int getPersonType() {
        return personType;
    }

    public void setPersonType(int personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return "PersonDocument{" +
                "id=" + id +
                ", name_cn='" + name_cn + '\'' +
                ", name_en='" + name_en + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", nativePlace='" + nativePlace + '\'' +
                ", bothPlace='" + bothPlace + '\'' +
                ", idCard='" + idCard + '\'' +
                ", insterestDesc='" + insterestDesc + '\'' +
                ", enterSchoolTime=" + enterSchoolTime +
                ", leaveSchoolTime=" + leaveSchoolTime +
                ", personType=" + personType +
                '}';
    }
}
