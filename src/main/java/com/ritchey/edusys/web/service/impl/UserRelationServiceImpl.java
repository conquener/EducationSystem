package com.ritchey.edusys.web.service.impl;

import com.ritchey.edusys.core.feature.orm.mybatis.Page;
import com.ritchey.edusys.web.dao.GroupMapper;
import com.ritchey.edusys.web.dao.RoleMapper;
import com.ritchey.edusys.web.dao.UsersMapper;
import com.ritchey.edusys.web.model.*;
import com.ritchey.edusys.web.service.IUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @
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

    @Override
    public Page<Users> selectUsersList(Map<String,Object> paramMap,Page<Users> page){
        List<Users> users = new ArrayList<Users>();
        try {
            UsersExample ue = new UsersExample();
            UsersExample.Criteria criteria = ue.createCriteria();
            if(paramMap.get("username")!=null && !paramMap.get("username").toString().equals("")){
                criteria.andUserNameEqualTo(paramMap.get("username").toString());
            }
            users  =  userMapper.selectByExampleAndPage(page,ue);
            page.setResult(users);
        }catch(Exception e){
            e.printStackTrace();
        }

        return page;
    }


    @Override
    public Page<Role> selectRolesList(Map<String, Object> paramMap, Page<Role> page) {
        List<Role> roles = new ArrayList<Role>();
        try {
            RoleExample re = new RoleExample();
            RoleExample.Criteria criteria = re.createCriteria();
            if(paramMap.get("roleName")!=null && !paramMap.get("roleName").toString().equals("")){
                criteria.andRoleNameEqualTo(paramMap.get("roleName").toString());
            }
            roles  =  roleMapper.selectByExampleAndPage(page,re);
            page.setResult(roles);
        }catch(Exception e){
            e.printStackTrace();
        }

        return page;
    }
}
