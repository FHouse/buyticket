package org.movie.service.impl;

import org.movie.dao.inf.CollectionInfoDao;
import org.movie.entity.CollectionInfo;
import org.movie.service.inf.CollectionInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "CollectionInfoService" )
public class CollectionInfoServiceImpl extends BaseServiceImpl implements CollectionInfoService{
    private CollectionInfoDao dao;
    @Override
    public List<CollectionInfo> findCollectionInfo() {
        return dao.findCollectionInfo();
    }
}
