package org.movie.service.impl;

import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.entity.FilmHouseUserInfo;
import org.movie.service.inf.FilmHouseUserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmHouseUserInfoService" )
public class FilmHouseUserInfoServiceImpl extends BaseServiceImpl implements FilmHouseUserInfoService{
    private FilmHouseUserInfoDao dao;

    @Override
    public List<FilmHouseUserInfo> findFilmHouseUserInfo() {
        return dao.findFilmHouseUserInfo();
    }
}
