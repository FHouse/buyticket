package org.movie.dao.impl;

import org.movie.dao.inf.CityDao;
import org.movie.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("CityDao")
public class CityDaoImpl extends BaseDaoImpl implements CityDao{
    @Override
    public List<City> findCity() {
        String jpql = "from City";
        return em.createQuery(jpql).getResultList();
    }
}
