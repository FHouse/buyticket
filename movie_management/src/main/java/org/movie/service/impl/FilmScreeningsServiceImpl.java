package org.movie.service.impl;

import org.movie.dao.inf.FilmScreeningsDao;
import org.movie.entity.FilmScreenings;
import org.movie.service.inf.FilmScreeningsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmScreeningsService" )
public class FilmScreeningsServiceImpl extends BaseServiceImpl implements FilmScreeningsService{
    private FilmScreeningsDao dao;
    @Override
    public List<FilmScreenings> findFilmScreenings() {
        return dao.findFilmScreenings();
    }
}
