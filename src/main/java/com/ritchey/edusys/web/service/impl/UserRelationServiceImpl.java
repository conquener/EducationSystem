package com.ritchey.edusys.web.service.impl;

import com.ritchey.edusys.core.generic.GenericDao;
import com.ritchey.edusys.core.generic.GenericServiceImpl;
import com.ritchey.edusys.web.dao.UsersMapper;
import com.ritchey.edusys.web.model.Group;
import com.ritchey.edusys.web.model.Permission;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.service.IUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class UserRelationServiceImpl implements  IUserRelationService{
    @Autowired
    private UsersMapper userMapper;

    @Override
    public List<Group> selectGroupByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Permission> selectPermissionsByRoleAndGroup(List<Long> roleIds, List<Long> groupIds) {
        return null;
    }

    @Override
    public List<Role> selectRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users("admin","Welcome123");
        return user;
    }

    @Override
    public Users authentication(Users user) {

        return userMapper.authentication(user);
    }
}
