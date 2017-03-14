package org.movie.service.impl;

import org.movie.dao.inf.FilmInfoDao;
import org.movie.entity.FilmInfo;
import org.movie.service.inf.FilmInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmInfoService" )
public class FilmInfoServiceImpl extends BaseServiceImpl implements FilmInfoService{
    private FilmInfoDao dao;
    @Override
    public List<FilmInfo> findFilmInfo() {
        return dao.findFilmInfo();
    }
}
