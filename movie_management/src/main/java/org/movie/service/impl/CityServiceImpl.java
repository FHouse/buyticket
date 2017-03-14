package org.movie.service.impl;

import org.movie.dao.inf.CityDao;
import org.movie.entity.City;
import org.movie.service.inf.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "CityService" )
public class CityServiceImpl extends BaseServiceImpl implements CityService{
    private CityDao dao;
    @Override
    public List<City> findCity() {
        return dao.findCity();
    }
}
