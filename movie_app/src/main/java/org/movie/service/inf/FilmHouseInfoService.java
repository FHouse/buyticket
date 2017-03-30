package org.movie.service.inf;

import org.movie.entity.Area;
import org.movie.entity.FilmHouseInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseInfoService{
    public List<FilmHouseInfo> findFilmHouseInfoByAreaId(Area area);
}
