package org.movie.service.impl;

import org.movie.dao.inf.FilmTypeDao;
import org.movie.entity.FilmType;
import org.movie.exception.FilmTypeException;
import org.movie.service.inf.FilmTypeService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Service("filmTypeService")
@Transactional
public class FilmTypeServiceImpl implements FilmTypeService {

    //注入dao
    @Autowired
    @Qualifier("filmTypeDao")
    private FilmTypeDao dao;

    @Override
    public boolean addFilmType(FilmType filmType){
        filmType.setFilmTypeId(UUIDUtil.getUUID());
        try{
            dao.findFilmTypeByTypeName(filmType);
            return false;
        }catch(Exception e){
            dao.save(filmType);
            return true;
        }
    }

    @Override
    public void updateFilmType(FilmType filmType) throws Exception {
        FilmType filmType1 = (FilmType) dao.findById(FilmType.class,filmType.getFilmTypeId());
        filmType1 = CheckVer.checkVer(filmType1,filmType,FilmType.class);
        dao.update(filmType1);
    }

    @Override
    public List<FilmType> findFilmTypes() {
        return dao.findAll(FilmType.class);
    }
}
