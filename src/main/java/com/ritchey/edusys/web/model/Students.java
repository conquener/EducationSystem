package com.ritchey.edusys.web.model;

/**
 * Created by Administrator on 2017/8/14.
 * 学生个人详细信息
 */
public class Students implements  java.io.Serializable{
    private Long id;
    //个人档案
    private Long personDocu;
    //所在班级
    private Long classId;
    //所在专业
    private Long major;
    //所属 院/系
    private Long yard;
    //所属学校
    private Long school;
    //学生当前学历
    private Long eduLevel;
    //学生保读性质(本硕连读,硕博连读,etc)
    private Long keepRead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonDocu() {
        return personDocu;
    }

    public void setPersonDocu(Long personDocu) {
        this.personDocu = personDocu;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    public Long getYard() {
        return yard;
    }

    public void setYard(Long yard) {
        this.yard = yard;
    }

    public Long getSchool() {
        return school;
    }

    public void setSchool(Long school) {
        this.school = school;
    }

    public Long getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Long eduLevel) {
        this.eduLevel = eduLevel;
    }

    public Long getKeepRead() {
        return keepRead;
    }

    public void setKeepRead(Long keepRead) {
        this.keepRead = keepRead;
    }
}
