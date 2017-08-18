package com.ritchey.edusys.core.shiro.authz;

import com.ritchey.edusys.web.model.Group;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/18.
 */
public class OverSimpleAuthorizationInfo extends SimpleAuthorizationInfo{
    protected Set<Group> objectGroups;

    public void addStringGroup(String group) {
        if(this.stringPermissions == null) {
            this.stringPermissions = new HashSet();
        }

        this.stringPermissions.add(group);
    }

    public void addStringGroups(Collection<String> group) {
        if(this.stringPermissions == null) {
            this.stringPermissions = new HashSet();
        }

        this.stringPermissions.addAll(group);
    }

    public Set<Group> getObjectGroups() {
        return objectGroups;
    }

    public void setObjectGroups(Set<Group> objectGroups) {
        this.objectGroups = objectGroups;
    }
}
