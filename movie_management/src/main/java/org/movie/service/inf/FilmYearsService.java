package org.movie.service.inf;

import org.movie.entity.FilmYears;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
public interface FilmYearsService {

    /**
     * 添加电影年代
     * @param filmYears
     */
    public boolean addFilmYears(FilmYears filmYears);

    /**
     * 修改电影年代
     * @param filmYears
     */
    public void updateFilmYears(FilmYears filmYears) throws Exception;

    /**
     * 查询所有的电影年代
     * @return
     */
    public List<FilmYears> findFilmYears();
}
