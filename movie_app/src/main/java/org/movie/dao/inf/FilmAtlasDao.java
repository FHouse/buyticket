package org.movie.dao.inf;

import org.movie.entity.FilmAtlas;
import org.movie.entity.FilmInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmAtlasDao extends BaseDao{
    public List<FilmAtlas> findFilmAtlasByFilmId(FilmInfo filmInfo);
}
