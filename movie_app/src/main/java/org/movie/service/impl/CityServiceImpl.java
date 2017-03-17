package org.movie.service.impl;

import org.movie.dao.inf.CityDao;
import org.movie.service.inf.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "cityService" )
@Transactional
public class CityServiceImpl extends BaseServiceImpl implements CityService{

    //注入dao
    @Autowired
    @Qualifier("cityDao")
    private CityDao dao;
}