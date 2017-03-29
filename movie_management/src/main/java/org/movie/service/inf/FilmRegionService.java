package org.movie.service.inf;

import org.movie.entity.FilmRegion;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmRegionService{

    /**
     * 添加地区
     * @param filmRegion
     */
    public void addFilmRegion(FilmRegion filmRegion);

    /**
     * 修改地区
     * @param filmRegion
     */
    public void updateFilmRegion(FilmRegion filmRegion) throws Exception;

    /**
     * 查询所有地区
     * @return 返回所有地区的list集合
     */
    public List<FilmRegion> findFilmRegions();

}
