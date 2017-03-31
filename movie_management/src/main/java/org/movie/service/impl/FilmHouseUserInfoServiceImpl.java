package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.entity.FilmHouseInfo;
import org.movie.entity.FilmHouseUserInfo;
import org.movie.service.inf.FilmHouseUserInfoService;
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
@Service( "filmHouseUserInfoService" )
@Transactional
public class FilmHouseUserInfoServiceImpl implements FilmHouseUserInfoService{
    //注入dao
    @Autowired
    @Qualifier("filmHouseUserInfoDao")
    private FilmHouseUserInfoDao dao;

    @Override
    public boolean addFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) {
        filmHouseUserInfo.setFilmHouseUserId(UUIDUtil.getUUID());
        try{
            dao.findFilmHouseUserByName(filmHouseUserInfo);
            return false;
        }catch(Exception e){
            dao.save(filmHouseUserInfo);
            return true;
        }
    }

    @Override
    public void deleteFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) {
        dao.delete(filmHouseUserInfo);
    }

    @Override
    public List<FilmHouseUserInfo> findFilmHouseUsers() {
        return dao.findAll(FilmHouseUserInfo.class);
    }

    @Override
    public void updateFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) throws Exception {
        FilmHouseUserInfo filmHouseUserInfo1 = (FilmHouseUserInfo) dao.findById(FilmHouseUserInfo.class,filmHouseUserInfo.getFilmHouseUserId());
        filmHouseUserInfo1 = CheckVer.checkVer(filmHouseUserInfo1,filmHouseUserInfo,FilmHouseUserInfo.class);
        dao.update(filmHouseUserInfo1);
    }

    @Override
    public FilmHouseUserInfo filmHouseUserLogin(FilmHouseUserInfo filmHouseUserInfo) {
        FilmHouseUserInfo filmHouseUserInfo1 = dao.findFilmHouseUserByName(filmHouseUserInfo);
        return filmHouseUserInfo1;
    }

    @Override
    public List<FilmHouseUserInfo> findFilmHouseUserByFilmHouseId(FilmHouseInfo filmHouseInfo) {
        return dao.findFilmHouseUsersByFilmHouseId(filmHouseInfo);
    }
}
