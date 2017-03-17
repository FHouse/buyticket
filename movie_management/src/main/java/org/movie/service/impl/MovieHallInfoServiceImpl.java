package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.MovieHallInfoDao;
import org.movie.entity.MovieHallInfo;
import org.movie.service.inf.MovieHallInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "movieHallInfoService" )
@Transactional
public class MovieHallInfoServiceImpl implements MovieHallInfoService{
    //注入dao
    @Autowired
    @Qualifier("movieHallInfoDao")
    private MovieHallInfoDao dao;
}
