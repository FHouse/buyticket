package org.movie.dao.impl;

import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.movie.entity.FilmInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmAtlasDao")
public class FilmAtlasDaoImpl extends BaseDaoImpl implements FilmAtlasDao{

    @Override
    public List<FilmAtlas> findFilmAtlasByFilmId(FilmInfo filmInfo) {
        String jpql = "from FilmAtlas e where e.filmInfo.filmId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmInfo.getFilmId());
        return query.getResultList();
    }
}
