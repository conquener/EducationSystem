package com.ritchey.edusys.web.model;

public class Group {
    private Long id;

    private String groupName;

    private String groupCode;

    private Integer groupType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (!(o instanceof Group)) {return false;}

        Group group = (Group) o;

        if (!getId().equals(group.getId())) {return false;}
        if (!getGroupName().equals(group.getGroupName())) {return false;}
        if (!getGroupCode().equals(group.getGroupCode())) {return false;}
        return getGroupType().equals(group.getGroupType());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getGroupName().hashCode();
        result = 31 * result + getGroupCode().hashCode();
        result = 31 * result + getGroupType().hashCode();
        return result;
    }
}