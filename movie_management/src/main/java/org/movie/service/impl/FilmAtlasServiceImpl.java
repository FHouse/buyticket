package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.movie.service.inf.FilmAtlasService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmAtlasService" )
@Transactional
public class FilmAtlasServiceImpl implements FilmAtlasService{
    //注入dao
    @Autowired
    @Qualifier("filmAtlasDao")
    private FilmAtlasDao dao;

    @Override
    public void addFilmAtlas(FilmAtlas filmAtlas) {
        filmAtlas.setFilmAtlasId(UUIDUtil.getUUID());
        dao.save(filmAtlas);
    }

    @Override
    public void addFilmAtlas(Set<FilmAtlas> atlasSet) {
        for (FilmAtlas filmAtlas:atlasSet) {
            filmAtlas.setFilmAtlasId(UUIDUtil.getUUID());
            dao.save(filmAtlas);
        }
    }

    @Override
    public void deleteFilmAtlas(FilmAtlas filmAtlas) {
        dao.delete(filmAtlas);
    }

    @Override
    public void deleteFilmAtlas(Set<FilmAtlas> atlasSet) {
        for (FilmAtlas f:atlasSet) {
            dao.delete(f);
        }
    }

    @Override
    public void updateFilmAtlas(FilmAtlas filmAtlas) throws Exception {
        FilmAtlas filmAtlas1 = (FilmAtlas) dao.findById(FilmAtlas.class,filmAtlas.getFilmAtlasId());
        filmAtlas1 = CheckVer.checkVer(filmAtlas1,filmAtlas,FilmAtlas.class);
        dao.update(filmAtlas1);
    }

    @Override
    public List<FilmAtlas> findFilmAtlases() {
        return dao.findAll(FilmAtlas.class);
    }

    @Override
    public List<FilmAtlas> findFilmAtlasByFilmId(FilmAtlas filmAtlas) {
        return dao.findFilmAtlasByFilmId(filmAtlas);
    }
}
