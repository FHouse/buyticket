package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmHouseUserInfoDao;
import org.movie.entity.FilmHouseInfo;
import org.movie.entity.FilmHouseUserInfo;
import org.movie.service.inf.FilmHouseUserInfoService;
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
    public void addFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) {
        filmHouseUserInfo.setFilmHouseUserId(UUIDUtil.getUUID());
        try{
            dao.findFilmHouseUserByName(filmHouseUserInfo);
        }catch(Exception e){
            dao.save(filmHouseUserInfo);
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
    public String updateFilmHouseUser(FilmHouseUserInfo filmHouseUserInfo) {
        try{
            dao.update(filmHouseUserInfo);
            return "修改成功！";
        }catch (Exception e){
            e.printStackTrace();
            return "修改失败！";
        }

    }

    @Override
    public String filmHouseUserLogin(FilmHouseUserInfo filmHouseUserInfo) {
        try{
            FilmHouseUserInfo filmHouseUserInfo1 = dao.findFilmHouseUserByName(filmHouseUserInfo);
            if((filmHouseUserInfo1 != null) && filmHouseUserInfo.getCinemaUserPassword().equals(filmHouseUserInfo1.getCinemaUserPassword())){
                return filmHouseUserInfo1.getCinemaUserName();
            }
            return "loginFail";
        }catch(Exception e){
            e.printStackTrace();
            return "loginFail";
        }
    }

    @Override
    public List<FilmHouseUserInfo> findFilmHouseUserByFilmHouseId(FilmHouseInfo filmHouseInfo) {
        return dao.findFilmHouseUsersByFilmHouseId(filmHouseInfo);
    }
}
