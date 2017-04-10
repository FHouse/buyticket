package org.movie.dao.inf;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.entity.FilmInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffInfoDao extends BaseDao{

    public List<ExecutiveStaffInfo> findExecutiveStaffInfoByFilmId(FilmInfo filmId);
}
