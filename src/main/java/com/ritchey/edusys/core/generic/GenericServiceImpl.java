package com.ritchey.edusys.core.generic;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public abstract class GenericServiceImpl<Model, PK>  implements  GenericService<Model, PK> {
    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericDao<Model, PK>  getDao();

    /**
     * 插入对象
     *
     * @param model 对象
     */
    @Override
    public int insert(Model model) {
        return getDao().insertSelective(model);
    }

    /**
     * 更新对象
     *
     * @param model 对象
     */
    @Override
    public int update(Model model) {
        return getDao().updateByPrimaryKeySelective(model);
    }

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    /*public int delete(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }*/

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return
     */
    @Override
    public Model selectById(PK id) {
        return getDao().selectByPrimaryKey(id);
    }


    @Override
    public Model selectOne() {
        return null;
    }

    @Override
    public List<Model> selectList() {
        return null;
    }


}
