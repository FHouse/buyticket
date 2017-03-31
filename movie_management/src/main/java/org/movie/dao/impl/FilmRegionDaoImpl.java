package org.movie.dao.impl;

import org.movie.dao.inf.FilmRegionDao;
import org.movie.entity.FilmRegion;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("filmRegionDao")
public class FilmRegionDaoImpl extends BaseDaoImpl implements FilmRegionDao{

    @Override
    public FilmRegion findFilmRegionByFilmRegionName(FilmRegion filmRegion) {
        String jpql = "from FilmRegion f where f.filmRegionName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmRegion.getFilmRegionName());
        return (FilmRegion) query.getSingleResult();
    }
}
