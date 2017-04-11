package org.movie.dao.inf;

import org.movie.entity.FilmType;

/**
 * Created by admin on 2017/3/30.
 */
public interface FilmTypeDao extends BaseDao{
    public FilmType findFilmTypeByTypeName(FilmType filmType);
}
