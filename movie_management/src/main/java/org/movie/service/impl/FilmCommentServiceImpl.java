package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.FilmCommentDao;
import org.movie.entity.FilmComment;
import org.movie.entity.FilmInfo;
import org.movie.service.inf.FilmCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmCommentService" )
@Transactional
public class FilmCommentServiceImpl implements FilmCommentService{
    //注入dao
    @Autowired
    @Qualifier("filmCommentDao")
    private FilmCommentDao dao;

    @Override
    public void deleteFilmCommentService(Set<FilmComment> filmComments) {
        for (FilmComment comment : filmComments) {
            comment = (FilmComment) dao.findById(FilmComment.class, comment.getFilmCommentId());
            dao.delete(comment);
        }
    }

    @Override
    public List<FilmComment> findFilmCommentByFilmId(FilmInfo filmInfo) {
        return dao.findFilmCommentByFilmId(filmInfo);
    }
}
