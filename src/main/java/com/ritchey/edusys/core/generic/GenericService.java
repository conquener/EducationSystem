package com.ritchey.edusys.core.generic;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface GenericService<Model,PK> {
    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insert(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int update(Model model);

    /**
     * 通过主键, 删除对象  关闭删除方法
     *
     * @param id 主键
     */
    /*int delete(PK id);*/

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Model selectById(PK id);


    /**
     * 查询单个对象
     *
     * @return 对象
     */
    Model selectOne();


    /**
     * 查询多个对象
     *
     * @return 对象集合
     */
    List<Model> selectList();

}
