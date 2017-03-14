package org.movie.dao.impl;

import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("AreaDao")
public class AreaDaoImpl extends BaseDaoImpl implements AreaDao {
    @Override
    public List<Area> findArea() {
        String jpql = "from Area";
        return em.createQuery(jpql).getResultList();
    }
}
