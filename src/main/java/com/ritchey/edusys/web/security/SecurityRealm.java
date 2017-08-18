package com.ritchey.edusys.web.security;

import com.ritchey.edusys.core.shiro.authz.OverSimpleAuthorizationInfo;
import com.ritchey.edusys.web.model.Group;
import com.ritchey.edusys.web.model.Permission;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户授权
 * Created by Administrator on 2017/8/16.
 */
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm{
    @Autowired
    public IUserRelationService userRelationService;
    private static final Logger log = Logger.getLogger(SecurityRealm.class);
    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = String.valueOf(authenticationToken.getPrincipal());
        String password = new String((char[]) authenticationToken.getCredentials());
        // 通过数据库进行验证
        final Users authentication = userRelationService.authentication(new Users(username, password));
        if (authentication == null) {
            log.info(username==null? username+ "登录失败!":"异常登录!");
            throw new AuthenticationException("用户名或密码错误.");

        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());

        return authenticationInfo;
    }

    /**
     * 权限控制
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        OverSimpleAuthorizationInfo authorizationInfo = new OverSimpleAuthorizationInfo();
        String username = String.valueOf(principalCollection.getPrimaryPrincipal());
        final Users user = userRelationService.selectUserByUserName(username);
        final List<Role> roles = userRelationService.selectRoleByUserId(user.getId());
        final List<Group> groups = userRelationService.selectGroupByUserId(user.getId());
        List<Long> roleIds = new ArrayList<Long>();
        List<Long> groupIds = new ArrayList<Long>();
        for (Role role : roles) {
            // 添加角色
            roleIds.add(role.getId());
            authorizationInfo.addRole(role.getRoleSign());
        }
        for (Group group : groups) {
            // 添加角色
            groupIds.add(group.getId());
            authorizationInfo.addStringGroup(group.getGroupName());
        }

        final List<Permission> permissions = userRelationService.selectPermissionsByRoleAndGroup(roleIds,groupIds);
        for (Permission permission : permissions) {
            // 添加权限
            authorizationInfo.addStringPermission(permission.getPermissionSign());
        }

        return authorizationInfo;
    }
}
