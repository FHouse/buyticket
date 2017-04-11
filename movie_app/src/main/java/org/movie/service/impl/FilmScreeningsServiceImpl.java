package org.movie.service.impl;

import org.movie.dao.inf.FilmScreeningsDao;
import org.movie.service.inf.FilmScreeningsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "filmScreeningsService" )
@Transactional
public class FilmScreeningsServiceImpl implements FilmScreeningsService{
    //注入dao
    @Autowired
    @Qualifier("filmScreeningsDao")
    private FilmScreeningsDao dao;
}
