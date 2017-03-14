package org.movie.service.inf;

import org.movie.entity.FilmScreenings;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmScreeningsService extends BaseService{
    public List<FilmScreenings> findFilmScreenings();
}
