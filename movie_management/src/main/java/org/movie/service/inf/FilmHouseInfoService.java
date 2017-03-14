package org.movie.service.inf;

import org.movie.entity.FilmHouseInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface FilmHouseInfoService extends BaseService{
    public List<FilmHouseInfo> findFilmHouseInfo();
}
