package org.movie.service.impl;

import org.movie.dao.inf.FilmCommentDao;
import org.movie.entity.FilmComment;
import org.movie.service.inf.FilmCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "FilmCommentService" )
public class FilmCommentServiceImpl extends BaseServiceImpl implements FilmCommentService{
    private FilmCommentDao dao;
    @Override
    public List<FilmComment> findFilmComment() {
        return dao.findFilmComment();
    }
}
