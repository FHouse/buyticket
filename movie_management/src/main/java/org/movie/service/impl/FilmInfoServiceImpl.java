package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmInfoDao;
import org.movie.entity.FilmInfo;
import org.movie.service.inf.FilmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmInfoService" )
@Transactional
public class FilmInfoServiceImpl implements FilmInfoService{
    //注入dao
    @Autowired
    @Qualifier("filmInfoDao")
    private FilmInfoDao dao;
}
