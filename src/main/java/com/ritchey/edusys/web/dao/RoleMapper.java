package com.ritchey.edusys.web.dao;

import com.ritchey.edusys.core.feature.orm.mybatis.Page;
import com.ritchey.edusys.web.model.Role;
import com.ritchey.edusys.web.model.RoleExample;
import java.util.List;

import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.model.UsersExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectRoleByUserId(Long userId);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<Role> selectByExampleAndPage(Page<Role> page, RoleExample example);
}