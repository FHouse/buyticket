package org.movie.service.impl;

import org.movie.dao.inf.MovieHallInfoDao;
import org.movie.entity.MovieHallInfo;
import org.movie.service.inf.MovieHallInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "MovieHallInfoService" )
public class MovieHallInfoServiceImpl extends BaseServiceImpl implements MovieHallInfoService{
    private MovieHallInfoDao dao;
    @Override
    public List<MovieHallInfo> findMovieHallInfo() {
        return dao.findMovieHallInfo();
    }
}
