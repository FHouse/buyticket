package org.movie.service.impl;

import org.movie.dao.inf.FilmRegionDao;
import org.movie.entity.FilmRegion;
import org.movie.service.inf.FilmRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmRegionService" )
@Transactional
public class FilmRegionServiceImpl extends BaseServiceImpl implements FilmRegionService{
    //注入dao
    @Autowired
    @Qualifier("filmRegionDao")
    private FilmRegionDao dao;

    @Override
    public List<FilmRegion> findFilmRegions() {
        return dao.findAll(FilmRegion.class);
    }
}
