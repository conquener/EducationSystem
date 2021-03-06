package com.ritchey.edusys.core.generic;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * Created by Administrator on 2017/8/18.
 */
public interface GenericDao<Model,PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象 关闭物理删除方法
     *
     * @param id 主键
     */
    /*int deleteByPrimaryKey(PK id);*/

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);

}
