package org.movie.service.impl;

import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;
import org.movie.service.inf.FilmHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmHouseInfoService" )
@Transactional
public class FilmHouseInfoServiceImpl implements FilmHouseInfoService{
    //注入dao
    @Autowired
    @Qualifier("filmHouseInfoDao")
    private FilmHouseInfoDao dao;

    @Override
    public List<FilmHouseInfo> findFilmHouseInfoByAreaId(Area area) {
        return dao.findFilmHouseInfoByAreaId(area);
    }
}
