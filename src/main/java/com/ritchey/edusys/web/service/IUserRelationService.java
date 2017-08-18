package com.ritchey.edusys.web.service;

import com.ritchey.edusys.core.generic.GenericService;
import com.ritchey.edusys.web.model.Group;
import com.ritchey.edusys.web.model.Permission;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;

import java.util.List;

/**
 * 用户相关Service ( 用户 user, 角色 role , 权限 permission  相关)
 * Created by Administrator on 2017/8/18.
 */
public interface IUserRelationService {
    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    public Users selectUserByUserName(String userName);

    /**
     * 通过用户Id 获取 Role
     * @param userId
     * @return
     */
    public List<Role> selectRoleByUserId(Long userId);

    /**
     * 通过用户Id 获取 Group
     * @param userId
     * @return
     */
    public List<Group> selectGroupByUserId(Long userId);

    /**
     * 通过角色Id 获取权限
     * @param roleIds,groupIds
     * @return
     */
    public List<Permission> selectPermissionsByRoleAndGroup(List<Long> roleIds,List<Long> groupIds);

    public Users authentication(Users user);
}
