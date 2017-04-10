package org.movie.dao.inf;

import org.movie.entity.FilmComment;
import org.movie.entity.FilmInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmCommentDao extends BaseDao{

    /**
     * 根据电影id查询该电影的所有评论
     * @param filmInfo
     * @return
     */
    public List<FilmComment> findFilmCommentByFilmId(FilmInfo filmInfo);
}
