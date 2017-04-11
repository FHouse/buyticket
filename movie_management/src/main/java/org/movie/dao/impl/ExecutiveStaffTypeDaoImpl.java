package org.movie.dao.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.entity.ExecutiveStaffType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("executiveStaffTypeDao")
public class ExecutiveStaffTypeDaoImpl extends BaseDaoImpl implements ExecutiveStaffTypeDao {

    @Override
    public ExecutiveStaffType findESTypeByName(ExecutiveStaffType executiveStaffType) {
        String jpql = "from ExecutiveStaffType e where e.typeName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,executiveStaffType.getTypeName());
        return (ExecutiveStaffType) query.getSingleResult();
    }

    @Override
    public ExecutiveStaffType findESTypeById(ExecutiveStaffType type) {
        String jpql = "from ExecutiveStaffType e left join fetch e.executiveStaffs where e.executiveStaffTypeId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,type.getExecutiveStaffTypeId());
        return (ExecutiveStaffType) query.getSingleResult();
    }
}
