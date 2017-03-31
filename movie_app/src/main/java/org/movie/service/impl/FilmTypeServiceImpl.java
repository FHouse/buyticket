package org.movie.service.impl;

import org.movie.dao.inf.FilmTypeDao;
import org.movie.entity.FilmType;
import org.movie.service.inf.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
@Service("filmTypeService")
@Transactional
public class FilmTypeServiceImpl implements FilmTypeService {

    //注入dao
    @Autowired
    @Qualifier("filmTypeDao")
    private FilmTypeDao dao;

    @Override
    public List<FilmType> findFilmTypes() {
        return dao.findAll(FilmType.class);
    }
}