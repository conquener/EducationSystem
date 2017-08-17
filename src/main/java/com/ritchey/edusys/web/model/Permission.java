package com.ritchey.edusys.web.model;

public class Permission {
    private String permissionname;

    private String permissionsign;

    private String permissiondesc;

    private Long id;

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public String getPermissionsign() {
        return permissionsign;
    }

    public void setPermissionsign(String permissionsign) {
        this.permissionsign = permissionsign == null ? null : permissionsign.trim();
    }

    public String getPermissiondesc() {
        return permissiondesc;
    }

    public void setPermissiondesc(String permissiondesc) {
        this.permissiondesc = permissiondesc == null ? null : permissiondesc.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}