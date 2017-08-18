package com.ritchey.edusys.web.dao;

import com.ritchey.edusys.web.model.GroupRoleRelationPermission;
import com.ritchey.edusys.web.model.GroupRoleRelationPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleRelationPermissionMapper {
    int countByExample(GroupRoleRelationPermissionExample example);

    int deleteByExample(GroupRoleRelationPermissionExample example);

    int insert(GroupRoleRelationPermission record);

    int insertSelective(GroupRoleRelationPermission record);

    List<GroupRoleRelationPermission> selectByExample(GroupRoleRelationPermissionExample example);

    int updateByExampleSelective(@Param("record") GroupRoleRelationPermission record, @Param("example") GroupRoleRelationPermissionExample example);

    int updateByExample(@Param("record") GroupRoleRelationPermission record, @Param("example") GroupRoleRelationPermissionExample example);
}