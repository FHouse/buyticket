package org.movie.dao.impl;

import org.movie.dao.inf.FilmScreeningsDao;
import org.movie.entity.FilmScreenings;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmScreeningsDao")
public class FilmScreeningsDaoImpl extends BaseDaoImpl implements FilmScreeningsDao{
    @Override
    public List<FilmScreenings> findFilmScreenings() {
        String jpql = "from FilmScreenings";
        return em.createQuery(jpql).getResultList();
    }
}
