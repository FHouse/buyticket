package org.movie.dao.inf;

import org.movie.entity.ExecutiveStaffInfo;
import org.movie.entity.FilmInfo;
import org.movie.util.PageBean;

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

    /**
     * 根据电影id查询该电影所有的演职人员(分页)
     * @param pageBean
     * @param filmInfo
     * @return
     */
    public PageBean findExecutiveStaffInfoByFilmId(PageBean pageBean, FilmInfo filmInfo);
}
