package org.movie.service.inf;

import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;

import java.util.List;

/**
 * 影城服务类接口
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseInfoService{

    /**
     * 添加影城信息
     * @param filmHouseInfo 需要添加的影城信息
     */
    public boolean add(FilmHouseInfo filmHouseInfo);

    /**
     * 删除影城信息
     * @param filmHouseInfo 需要删除的影城信息
     */
    public void delete(FilmHouseInfo filmHouseInfo);

    /**
     * 查询所有的影城信息
     * @return 返回所有影城信息的集合
     */
    public List<FilmHouseInfo> findFilmHouseInfos();

    /**
     * 根据区（县）信息查询该区域内的影城
     * @param area 区（县）信息
     * @return 返回该区域所有的影城的信息集合
     */
    public List<FilmHouseInfo> findFilmHouseInfoByAreaId(Area area);

    /**
     * 修改影城信息
     * @param filmHouseInfo 需要修改的影城信息
     */
    public void update(FilmHouseInfo filmHouseInfo) throws Exception;
}
