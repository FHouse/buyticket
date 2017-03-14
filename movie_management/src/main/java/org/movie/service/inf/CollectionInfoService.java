package org.movie.service.inf;

import org.movie.entity.CollectionInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface CollectionInfoService extends BaseService{
    public List<CollectionInfo> findCollectionInfo();
}
