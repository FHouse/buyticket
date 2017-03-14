package org.movie.service.impl;

import org.movie.dao.inf.BaseDao;
import org.movie.service.inf.BaseService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "BaseService" )
public class BaseServiceImpl<T> implements BaseService<T>{
    private BaseDao dao;
    @Override
    public void save(T t) {
        try{
            dao.save(t);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(T t) {
        try{
            dao.delete(t);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(T t) {
        try{
            dao.update(t);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public T findById(Class<T> entityClass, Serializable id) {
        return (T) dao.findById(entityClass,id);
    }
}
