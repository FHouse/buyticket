package org.movie.service.impl;

import org.movie.dao.inf.FilmCommentDao;
import org.movie.service.inf.FilmCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
