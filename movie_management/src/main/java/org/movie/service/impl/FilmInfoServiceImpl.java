package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmInfoDao;
import org.movie.entity.FilmInfo;
import org.movie.service.inf.FilmInfoService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
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

    @Override
    public boolean addFilmInfo(FilmInfo filmInfo) {
        filmInfo.setFilmId(UUIDUtil.getUUID());
        try{
            dao.findFilmInfoByName(filmInfo);
            return false;
        }catch(Exception e){
            dao.save(filmInfo);
            return true;
        }
    }

    @Override
    public void updateFilmInfo(FilmInfo filmInfo) throws Exception {
        FilmInfo filmInfo1 = (FilmInfo) dao.findById(FilmInfo.class,filmInfo.getFilmId());
        filmInfo1 = CheckVer.checkVer(filmInfo1,filmInfo,FilmInfo.class);
        dao.update(filmInfo1);
    }

    @Override
    public List<FilmInfo> findFilmInfos() {
        return dao.findAll(FilmInfo.class);
    }

    @Override
    public FilmInfo findFilmInfoById(FilmInfo filmInfo) {
        return (FilmInfo) dao.findById(FilmInfo.class,filmInfo.getFilmId());
    }
}
