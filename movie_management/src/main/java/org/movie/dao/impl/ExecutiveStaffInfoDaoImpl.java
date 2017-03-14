package org.movie.dao.impl;

import org.movie.dao.inf.ExecutiveStaffInfoDao;
import org.movie.entity.ExecutiveStaffInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("ExecutiveStaffInfoDao")
public class ExecutiveStaffInfoDaoImpl extends BaseDaoImpl implements ExecutiveStaffInfoDao {
    @Override
    public List<ExecutiveStaffInfo> findExecutiveStaffInfo() {
        String jpql = "from ExecutiveStaffInfo";
        return em.createQuery(jpql).getResultList();
    }
}
