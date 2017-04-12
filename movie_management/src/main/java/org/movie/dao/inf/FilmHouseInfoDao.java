package org.movie.dao.inf;

import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;
import org.movie.util.PageBean;

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
    public PageBean findFilmHouseInfoByAreaId(PageBean pageBean,Area area);

    /**
     * 根据区（县）id删除该区域内的所有影城
     * @param area 需要删除的区（县）的信息
     */
    public void deleteFilmHouseInfoByAreaId(Area area);

    /**
     * 根据影城名称查询该影城信息
     * @param filmHouseInfo
     * @return
     */
    public FilmHouseInfo findFilmHouseInfoByFilmHouseName(FilmHouseInfo filmHouseInfo);
}
