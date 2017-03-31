package org.movie.dao.impl;

import org.movie.dao.inf.FilmYearsDao;
import org.movie.entity.FilmYears;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Repository("filmYearsDao")
public class FilmYearsDaoImpl extends BaseDaoImpl implements FilmYearsDao {

    @Override
    public FilmYears findFilmYearsByFilmYearsName(FilmYears filmYears) {
        String jpql = "from FilmYears f where f.filmYearsName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmYears.getFilmYearsName());
        return (FilmYears) query.getSingleResult();

    }
}
