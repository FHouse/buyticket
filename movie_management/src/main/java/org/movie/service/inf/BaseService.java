package org.movie.service.inf;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface BaseService<T> {

    public void save(T t);
    public void delete(T t);
    public void update(T t);
    public T findById(Class<T> entityClass, Serializable id);
    public List<T> findAll(Class<T> entityClass);
}
