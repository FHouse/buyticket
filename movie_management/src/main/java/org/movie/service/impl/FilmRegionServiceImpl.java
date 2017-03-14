package org.movie.service.impl;

import org.movie.dao.inf.FilmRegionDao;
import org.movie.entity.FilmRegion;
import org.movie.service.inf.FilmRegionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmRegionService" )
public class FilmRegionServiceImpl extends BaseServiceImpl implements FilmRegionService{
    private FilmRegionDao dao;
    @Override
    public List<FilmRegion> findFilmRegion() {
        return dao.findFilmRegion();
    }
}
