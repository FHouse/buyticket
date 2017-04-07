package org.movie.dao.inf;

import org.movie.entity.FilmInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmInfoDao extends BaseDao{

    /**
     * 根据电影名称查询电影信息
     * @param filmInfo
     * @return
     */
    public FilmInfo findFilmInfoByName(FilmInfo filmInfo);
}
