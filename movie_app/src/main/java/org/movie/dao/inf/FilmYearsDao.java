package org.movie.dao.inf;

import org.movie.entity.FilmYears;

/**
 * Created by admin on 2017/3/30.
 */
public interface FilmYearsDao extends BaseDao{
    public FilmYears findFilmYearsByFilmYearsName(FilmYears filmYears);
}
