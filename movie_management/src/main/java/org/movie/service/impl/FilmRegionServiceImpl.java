package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmRegionDao;
import org.movie.entity.FilmRegion;
import org.movie.service.inf.FilmRegionService;
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
@Service( "filmRegionService" )
@Transactional
public class FilmRegionServiceImpl implements FilmRegionService{
    //注入dao
    @Autowired
    @Qualifier("filmRegionDao")
    private FilmRegionDao dao;

    @Override
    public boolean addFilmRegion(FilmRegion filmRegion) {
        filmRegion.setFilmRegionId(UUIDUtil.getUUID());
        try{
            dao.findFilmRegionByFilmRegionName(filmRegion);
            return false;
        }catch(Exception e){
            dao.save(filmRegion);
            return true;
        }

    }

    @Override
    public void updateFilmRegion(FilmRegion filmRegion) throws Exception {
        FilmRegion filmRegion1 = (FilmRegion) dao.findById(FilmRegion.class,filmRegion.getFilmRegionId());
        filmRegion1 = CheckVer.checkVer(filmRegion1,filmRegion,FilmRegion.class);
        dao.update(filmRegion1);
    }

    @Override
    public List<FilmRegion> findFilmRegions() {
        return dao.findAll(FilmRegion.class);
    }
}
