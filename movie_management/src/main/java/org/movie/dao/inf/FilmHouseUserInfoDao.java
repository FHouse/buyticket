package org.movie.dao.inf;

import org.movie.entity.FilmHouseUserInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseUserInfoDao extends BaseDao{
    public List<FilmHouseUserInfo> findFilmHouseUserInfo();

}
