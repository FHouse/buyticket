package org.movie.dao.impl;

import org.movie.dao.inf.BaseDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * 基础dao实现类
 * Created by Wkz on 2017/2/27.
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

    //注入EntityManager
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void save(T t) {
        em.persist(t);
    }

    @Override
    public void delete(T t) {
        em.remove(em.merge(t));
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public T findById(Class<T> entityClass, Serializable id) {
        return em.find(entityClass,id);
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        String jpql = "from "+entityClass.getName();
        return em.createQuery(jpql).getResultList();
    }

}
