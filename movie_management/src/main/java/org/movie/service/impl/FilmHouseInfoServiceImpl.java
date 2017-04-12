package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmHouseInfoDao;
import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;
import org.movie.service.inf.FilmHouseInfoService;
import org.movie.util.CheckVer;
import org.movie.util.PageBean;
import org.movie.util.UUIDUtil;
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
    public boolean add(FilmHouseInfo filmHouseInfo) {
        filmHouseInfo.setFilmHouseId(UUIDUtil.getUUID());
        try{
            dao.findFilmHouseInfoByFilmHouseName(filmHouseInfo);
            return false;
        }catch(Exception e){
            dao.save(filmHouseInfo);
            return true;
        }

    }

    @Override
    public void delete(FilmHouseInfo filmHouseInfo) {
        dao.delete(filmHouseInfo);
    }

    @Override
    public PageBean findFilmHouseInfos(PageBean pageBean) {
        return dao.findAll(pageBean,FilmHouseInfo.class);
    }

    @Override
    public PageBean findFilmHouseInfoByAreaId(PageBean pageBean,Area area) {
        return dao.findFilmHouseInfoByAreaId(pageBean,area);
    }

    @Override
    public void update(FilmHouseInfo filmHouseInfo) throws Exception {
        FilmHouseInfo filmHouseInfo1 = (FilmHouseInfo) dao.findById(FilmHouseInfo.class,filmHouseInfo.getFilmHouseId());
        filmHouseInfo1 = CheckVer.checkVer(filmHouseInfo1,filmHouseInfo,FilmHouseInfo.class);
        dao.update(filmHouseInfo1);
    }
}
