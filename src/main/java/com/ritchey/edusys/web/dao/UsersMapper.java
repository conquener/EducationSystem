package com.ritchey.edusys.web.dao;

import com.ritchey.edusys.core.feature.orm.mybatis.Page;
import com.ritchey.edusys.web.model.Users;
import com.ritchey.edusys.web.model.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {

    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    Users authentication(@Param("record") Users record);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<Users> selectByExampleAndPage(Page<Users> page, UsersExample example);
}