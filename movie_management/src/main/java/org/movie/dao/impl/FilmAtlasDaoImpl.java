package org.movie.dao.impl;

import org.movie.dao.inf.FilmAtlasDao;
import org.movie.entity.FilmAtlas;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmAtlasDao")
public class FilmAtlasDaoImpl extends BaseDaoImpl implements FilmAtlasDao{
    @Override
    public List<FilmAtlas> findFilmAtlas() {
        String jpql = "from FilmAtlas";
        return em.createQuery(jpql).getResultList();
    }
}
