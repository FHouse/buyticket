package org.movie.service.impl;

import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.movie.service.inf.FilmAtlasService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmAtlasService" )
public class FilmAtlasServiceImpl extends BaseServiceImpl implements FilmAtlasService{
    private FilmAtlasDao dao;
    @Override
    public List<FilmAtlas> findFilmAtlas() {
        return dao.findFilmAtlas();
    }
}
