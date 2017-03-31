package org.movie.dao.impl;

import org.movie.dao.inf.CityDao;
import org.movie.entity.Area;
import org.movie.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl implements CityDao{

    public City find(String cityId){
        String jpql = "from City c left join fetch c.areas where c.cityId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,cityId);
        return (City)query.getSingleResult();
    }

    @Override
    public City findCityByCityName(City city) {
        String jpql = "from City c where c.cityName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,city.getCityName());
        return (City) query.getSingleResult();
    }
}
