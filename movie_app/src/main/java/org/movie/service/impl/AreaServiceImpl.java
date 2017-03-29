package org.movie.service.impl;

import org.movie.dao.impl.AreaDaoImpl;
import org.movie.entity.Area;
import org.movie.entity.City;
import org.movie.service.inf.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "areaService" )
@Transactional
public class AreaServiceImpl extends BaseServiceImpl implements AreaService{

    //注入dao
    @Autowired
    @Qualifier("areaDao")
    private AreaDaoImpl dao;

    @Override
    public List<Area> findAreaByCityId(City city) {
        return dao.findAreaByCityId(city);
    }

    @Override
    public List<Area> findAreas() {
        return dao.findAll(Area.class);
    }
}
