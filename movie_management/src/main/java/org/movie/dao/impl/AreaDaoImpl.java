package org.movie.dao.impl;

import org.movie.dao.inf.AreaDao;
import org.movie.entity.Area;
import org.movie.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("areaDao")
public class AreaDaoImpl extends BaseDaoImpl implements AreaDao {

    @Override
    public List<Area> findAreaByCityId(City city) {
        String jpql = "from Area a where a.city.cityId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,city.getCityId());
        return query.getResultList();
    }

    @Override
    public Area findAreaByAreaName(Area area) {
        String jpql = "form Area a where a.areaName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,area.getAreaName());
        return (Area) query.getSingleResult();
    }
}
