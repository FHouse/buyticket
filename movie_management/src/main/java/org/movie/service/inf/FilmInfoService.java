package org.movie.service.inf;

import org.movie.entity.FilmInfo;
import org.movie.util.PageBean;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmInfoService{

    /**
     * 添加电影信息
     * @param filmInfo
     * @return
     */
    public boolean addFilmInfo(FilmInfo filmInfo);

    /**
     * 修改电影信息
     * @param filmInfo
     */
    public void updateFilmInfo(FilmInfo filmInfo) throws Exception;

    /**
     * 查询所有的电影信息
     * @return
     */
    public PageBean findFilmInfos(PageBean pageBean);

    /**
     *根据电影id查询电影信息
     * @param filmInfo
     * @return
     */
    public FilmInfo findFilmInfoById(FilmInfo filmInfo);
}
