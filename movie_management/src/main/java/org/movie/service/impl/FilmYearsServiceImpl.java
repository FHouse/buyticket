package org.movie.service.impl;

import org.movie.dao.inf.FilmYearsDao;
import org.movie.entity.FilmYears;
import org.movie.service.inf.FilmYearsService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Service("filmYearsService")
@Transactional
public class FilmYearsServiceImpl implements FilmYearsService {

    //注入dao
    @Autowired
    @Qualifier("filmYearsDao")
    private FilmYearsDao dao;

    @Override
    public boolean addFilmYears(FilmYears filmYears) {
        filmYears.setFilmYearsId(UUIDUtil.getUUID());
        try{
            dao.findFilmYearsByFilmYearsName(filmYears);
            return false;
        }catch(Exception e){
            dao.save(filmYears);
            return true;
        }

    }

    @Override
    public void updateFilmYears(FilmYears filmYears) throws Exception {
        FilmYears filmYears1 = (FilmYears) dao.findById(FilmYears.class,filmYears.getFilmYearsId());
        filmYears1 = CheckVer.checkVer(filmYears1,filmYears,FilmYears.class);
        dao.update(filmYears1);
    }

    @Override
    public List<FilmYears> findFilmYears() {
        return dao.findAll(FilmYears.class);
    }
}
