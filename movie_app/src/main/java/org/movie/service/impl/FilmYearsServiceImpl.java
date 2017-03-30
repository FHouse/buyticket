package org.movie.service.impl;

import org.movie.dao.inf.FilmYearsDao;
import org.movie.entity.FilmYears;
import org.movie.service.inf.FilmYearsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
@Service("filmYearsService")
@Transactional
public class FilmYearsServiceImpl implements FilmYearsService {
    //注入dao
    @Autowired
    @Qualifier("filmYearsDao")
    private FilmYearsDao dao;
    @Override
    public List<FilmYears> findFilmYears() {
        return dao.findAll(FilmYears.class);
    }
}
