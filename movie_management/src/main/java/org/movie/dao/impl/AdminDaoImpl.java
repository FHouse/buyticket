package org.movie.dao.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.entity.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl implements AdminDao{

    @Override
    public Admin findAdminByName(Admin admin) {
        String jpql = "from Admin a where a.adminName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,admin.getAdminName());
        return (Admin) query.getSingleResult();
    }
}
