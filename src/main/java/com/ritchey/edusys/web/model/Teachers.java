package com.ritchey.edusys.web.model;

/**
 * Created by Administrator on 2017/8/14.
 * 教师个人详细信息
 */
public class Teachers implements  java.io.Serializable{
    private Long id;
    //教师个人档案
    private Long personDocu;
    //所在专业
    private Long major;
    //所属 院/系
    private Long yard;
    //所属学校
    private Long school;
    //教师学历
    private Long eduLevel;
    //教师教育经历描述
    private String eduEpcontext;
    //行政级别
    private Long level;
    //职称
    private Long professional;

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

    public String getEduEpcontext() {
        return eduEpcontext;
    }

    public void setEduEpcontext(String eduEpcontext) {
        this.eduEpcontext = eduEpcontext;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getProfessional() {
        return professional;
    }

    public void setProfessional(Long professional) {
        this.professional = professional;
    }

}
