package com.ritchey.edusys.web.model;

import java.math.BigDecimal;

public class Role {
    private Long id;

    private String rolename;

    private String desc;

    private String rolesign;

    private Byte valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getRolesign() {
        return rolesign;
    }

    public void setRolesign(String rolesign) {
        this.rolesign = rolesign == null ? null : rolesign.trim();
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}