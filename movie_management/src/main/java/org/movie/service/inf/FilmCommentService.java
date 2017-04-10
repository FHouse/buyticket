package org.movie.service.inf;

import org.movie.entity.FilmComment;
import org.movie.entity.FilmInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmCommentService{

    /**
     * 同时删除多条评论
     * @param filmComments
     */
    public void deleteFilmCommentService(Set<FilmComment> filmComments);

    /**
     * 根据电影id查询该电影的所有的评论
     * @param filmInfo
     * @return
     */
    public List<FilmComment> findFilmCommentByFilmId(FilmInfo filmInfo);
}
