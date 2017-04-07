package org.movie.service.inf;

import org.movie.entity.ExecutiveStaffInfo;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffInfoService{

    /**
     * 添加演职人员
     * @param executiveStaffInfo
     * @return
     */
    public void addExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo);

    /**
     * 根据id删除演职人员
     * @param executiveStaffInfo
     */
    public void deleteExecutiveStaffInfoByID(ExecutiveStaffInfo executiveStaffInfo);

    /**
     * 根据电影id删除演职人员
     * @param filmId
     */
    public void deleteExecutiveStaffInfoByFilmID(String filmId);

    /**
     * 修改演职人员
     * @param executiveStaffInfo
     */
    public void updateExecutiveStaffInfo(ExecutiveStaffInfo executiveStaffInfo) throws Exception;

    /**
     * 查询所有的演职人员
     * @return
     */
    public List<ExecutiveStaffInfo> findExecutiveStaffInfos();

    public List<ExecutiveStaffInfo> find();
}
