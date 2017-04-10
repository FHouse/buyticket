package org.movie.service.inf;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.entity.FilmInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffInfoService{
    public List<ExecutiveStaffInfo> findExecutiveStaffInfoByFilmId(FilmInfo filmId);
}
