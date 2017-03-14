package org.movie.dao.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("AdminDao")
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao{
    @Override
    public List<Admin> findAdmin() {
        String jpql = "from Admin";
        return em.createQuery(jpql).getResultList();
    }
}
