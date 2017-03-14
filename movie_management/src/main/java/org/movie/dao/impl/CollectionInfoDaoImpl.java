package org.movie.dao.impl;

import org.movie.dao.inf.CollectionInfoDao;
import org.movie.entity.CollectionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("CollectionInfoDao")
public class CollectionInfoDaoImpl extends BaseDaoImpl implements CollectionInfoDao{
    @Override
    public List<CollectionInfo> findCollectionInfo() {
        String jpql = "from CollectionInfo";
        return em.createQuery(jpql).getResultList();
    }
}
