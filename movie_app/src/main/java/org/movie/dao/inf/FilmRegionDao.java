package org.movie.dao.inf;

import org.movie.entity.FilmRegion;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmRegionDao extends BaseDao{

    public FilmRegion findFilmRegionByFilmRegionName(FilmRegion filmRegion);
}
