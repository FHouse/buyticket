package org.movie.dao.inf;

import org.movie.entity.CollectionInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface CollectionInfoDao extends BaseDao{
    public List<CollectionInfo> findCollectionInfo();
}
