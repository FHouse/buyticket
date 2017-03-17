package org.movie.service.impl;

import org.movie.dao.inf.AreaDao;
import org.movie.dao.inf.CityDao;
import org.movie.entity.City;
import org.movie.service.inf.CityService;
import org.movie.util.CheckVer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{

    //注入城市dao
    @Autowired
    @Qualifier("cityDao")
    private CityDao dao;

    //注入区（县）dao
    @Autowired
    @Qualifier("areaDao")
    private AreaDao areaDao;

    @Override
    public void add(City city) {
        dao.save(city);
    }

    @Override
    public List<City> findCitys() {
        return dao.findAll(City.class);
    }

    @Override
    public void update(City city) throws Exception {
        City city1 = (City)dao.findById(City.class,city.getCityId());
        city1  = CheckVer.checkVer(city1,city,City.class);
        dao.update(city1);
    }

    @Override
    public void delete(City city) {
        areaDao.deleteAreaByCityId(city);
        dao.delete(city);
    }
}
