package org.movie.service.impl;

import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.entity.FilmHouseInfo;
import org.movie.service.inf.FilmHouseInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmHouseInfoService" )
public class FilmHouseInfoServiceImpl extends BaseServiceImpl implements FilmHouseInfoService{
    private FilmHouseInfoDao dao;
    @Override
    public List<FilmHouseInfo> findFilmHouseInfo() {
        return dao.findFilmHouseInfo();
    }
}
