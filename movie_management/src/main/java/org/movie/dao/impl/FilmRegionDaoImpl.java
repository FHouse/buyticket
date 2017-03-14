package org.movie.dao.impl;

import org.movie.dao.inf.FilmRegionDao;
import org.movie.entity.FilmRegion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmRegionDao")
public class FilmRegionDaoImpl extends BaseDaoImpl implements FilmRegionDao{
    @Override
    public List<FilmRegion> findFilmRegion() {
        String jpql = "from FilmRegion";
        return em.createQuery(jpql).getResultList();
    }
}
