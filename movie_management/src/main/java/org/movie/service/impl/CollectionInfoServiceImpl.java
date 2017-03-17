package org.movie.service.impl;

import org.movie.dao.inf.CollectionInfoDao;
import org.movie.entity.CollectionInfo;
import org.movie.service.inf.CollectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "collectionInfoService" )
@Transactional
public class CollectionInfoServiceImpl implements CollectionInfoService{

    //注入dao
    @Autowired
    @Qualifier("collectionInfoDao")
    private CollectionInfoDao dao;
}
