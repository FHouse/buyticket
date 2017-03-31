package org.movie.dao.inf;

import org.movie.entity.FilmYears;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
public interface FilmYearsDao extends BaseDao {

    /**
     * 根据年代名称查询年代信息
     * @param filmYears
     * @return
     */
    public FilmYears findFilmYearsByFilmYearsName(FilmYears filmYears);
}
