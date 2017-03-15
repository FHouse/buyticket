package org.movie.service.impl;

import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.service.inf.FilmHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmHouseInfoService" )
@Transactional
public class FilmHouseInfoServiceImpl extends BaseServiceImpl implements FilmHouseInfoService{
    //注入dao
    @Autowired
    @Qualifier("filmHouseInfoDao")
    private FilmHouseInfoDao dao;
}
