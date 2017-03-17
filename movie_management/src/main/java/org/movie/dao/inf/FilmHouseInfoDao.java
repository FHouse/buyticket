package org.movie.dao.inf;

import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseInfoDao extends BaseDao{

    /**
     * 根据区（县）信息查询该区域内的所有影城
     * @param area 需要查询的区（县）信息
     * @return 返回该区域内的所有影城的信息的集合
     */
    public List<FilmHouseInfo> findFilmHouseInfoByAreaId(Area area);
}