package org.movie.dao.impl;

import org.movie.dao.inf.FilmTypeDao;
import org.movie.entity.FilmType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by admin on 2017/3/30.
 */
@Repository("filmTypeDao")
public class FilmTypeDaoImpl extends BaseDaoImpl implements FilmTypeDao {
    @Override
    public FilmType findFilmTypeByTypeName(FilmType filmType) {
        String jpql = "from FilmType f where f.filmTypeName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,filmType.getFilmTypeName());
        return (FilmType) query.getSingleResult();
    }
}
