package org.movie.service.inf;

import org.movie.entity.MovieHallInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface MovieHallInfoService extends BaseService{
    public List<MovieHallInfo> findMovieHallInfo();
}
