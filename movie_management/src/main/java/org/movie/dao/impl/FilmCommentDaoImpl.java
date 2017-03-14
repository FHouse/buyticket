package org.movie.dao.impl;

import org.movie.dao.inf.FilmCommentDao;
import org.movie.entity.FilmComment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("FilmCommentDao")
public class FilmCommentDaoImpl extends BaseDaoImpl implements FilmCommentDao{
    @Override
    public List<FilmComment> findFilmComment() {
        String jpql = "from FilmComment";
        return em.createQuery(jpql).getResultList();
    }
}
