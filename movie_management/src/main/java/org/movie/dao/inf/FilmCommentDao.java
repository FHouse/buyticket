package org.movie.dao.inf;

import org.movie.entity.FilmComment;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmCommentDao extends BaseDao{
    public List<FilmComment> findFilmComment();
}
