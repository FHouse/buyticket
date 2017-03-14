package org.movie.dao.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.entity.ExecutiveStaffType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("ExecutiveStaffTypeDao")
public class ExecutiveStaffTypeDaoImpl extends BaseDaoImpl implements ExecutiveStaffTypeDao {
    @Override
    public List<ExecutiveStaffType> findExecutiveStaffType() {
        String jpql = "from ExecutiveStaffType";
        return em.createQuery(jpql).getResultList();
    }
}
