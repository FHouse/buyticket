package org.movie.service.impl;

import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.movie.service.inf.FilmAtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmAtlasService" )
@Transactional
public class FilmAtlasServiceImpl extends BaseServiceImpl implements FilmAtlasService{
    //注入dao
    @Autowired
    @Qualifier("filmAtlasDao")
    private FilmAtlasDao dao;

    @Override
    public List<FilmAtlas> findFilmAtlasByFilmId(FilmAtlas filmAtlas) {
        return dao.findFilmAtlasByFilmId(filmAtlas);
    }
}
