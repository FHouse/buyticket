package org.movie.dao.inf;

import java.io.Serializable;
import java.util.List;

/**
 * 基础dao接口
 * Created by Wkz on 2017/2/27.
 */
public interface BaseDao<T> {
    /**
     * 添加
     * @param t 需要添加的实体
     */
    public void save(T t);

    /**
     * 删除
     * @param t 需要删除的实体，实体中必须有需要删除的实体的id
     */
    public void delete(T t);

    /**
     * 修改
     * @param t 需要修改的实体，实体中必须有需要删除的实体的id
     */
    public void update(T t);

    /**
     * 根据id查询
     * @param entityClass 需要查询的实体的Class对象
     * @param id 查询所需的key
     * @return 返回查到的实体数据
     */
    public T findById(Class<T> entityClass, Serializable id);

    /**
     *查询所有数据
     * @param entityClass 需要查询的类的Class对象
     * @return 返回查询数据的集合
     */
    public List<T> findAll(Class<T> entityClass);

}
