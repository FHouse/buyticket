package org.movie.service.impl;

import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.service.inf.FilmHouseUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmHouseUserInfoService" )
@Transactional
public class FilmHouseUserInfoServiceImpl implements FilmHouseUserInfoService{
    //注入dao
    @Autowired
    @Qualifier("filmHouseUserInfoDao")
    private FilmHouseUserInfoDao dao;
}
