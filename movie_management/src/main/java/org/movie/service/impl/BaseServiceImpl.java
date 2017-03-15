package org.movie.service.impl;

import org.movie.dao.inf.BaseDao;
import org.movie.service.inf.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "baseService" )
public class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    @Qualifier("baseDao")
    protected BaseDao dao;

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

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return dao.findAll(entityClass);
    }
}
