package org.movie.dao.inf;

import org.movie.entity.ExecutiveStaffInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffInfoDao extends BaseDao{

    /**
     * 根据电影id查询该电影所有的演职人员
     * @param filmId
     * @return
     */
    public List<ExecutiveStaffInfo> findExecutiveStaffInfoByFilmId(String filmId);

    public List<ExecutiveStaffInfo> findExecutive();
}
