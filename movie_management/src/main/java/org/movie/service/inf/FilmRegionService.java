package org.movie.service.inf;

import org.movie.entity.FilmRegion;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmRegionService extends BaseService{
    public List<FilmRegion> findFilmRegion();
}
