package com.ritchey.edusys.web.dao;

import com.ritchey.edusys.web.model.UserGroupRelation;
import com.ritchey.edusys.web.model.UserGroupRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupRelationMapper {
    int countByExample(UserGroupRelationExample example);

    int deleteByExample(UserGroupRelationExample example);

    int insert(UserGroupRelation record);

    int insertSelective(UserGroupRelation record);

    List<UserGroupRelation> selectByExample(UserGroupRelationExample example);

    int updateByExampleSelective(@Param("record") UserGroupRelation record, @Param("example") UserGroupRelationExample example);

    int updateByExample(@Param("record") UserGroupRelation record, @Param("example") UserGroupRelationExample example);
}