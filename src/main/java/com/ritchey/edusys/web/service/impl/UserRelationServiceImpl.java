package com.ritchey.edusys.web.service.impl;

import com.ritchey.edusys.web.dao.GroupMapper;
import com.ritchey.edusys.web.dao.RoleMapper;
import com.ritchey.edusys.web.dao.UsersMapper;
import com.ritchey.edusys.web.model.Group;
import com.ritchey.edusys.web.model.Permission;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class UserRelationServiceImpl implements  IUserRelationService{
    @Autowired
    private UsersMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<Group> selectGroupByUserId(Long userId) {
        List<Group> groups = new ArrayList<Group>();
        groups =  groupMapper.selectGroupByUserId(userId);
        return groups;
    }

    @Override
    public List<Permission> selectPermissionsByRoleAndGroup(List<Long> roleIds, List<Long> groupIds) {
        List<Permission>  pms= new ArrayList<Permission>();
        return pms;
    }

    @Override
    public List<Role> selectRoleByUserId(Long userId) {
        List<Role> roles = new ArrayList<Role>();
        roles = roleMapper.selectRoleByUserId(userId);
        return roles;
    }

    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users("admin","Welcome123");
        return user;
    }

    @Override
    public Users authentication(Users user) {
        try {
            user =   userMapper.authentication(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
