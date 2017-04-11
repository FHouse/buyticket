package org.movie.service.inf;

import org.movie.entity.ExecutiveStaffType;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffTypeService{

    /**
     * 添加演职人员类型
     * @param executiveStaffType
     * @return
     */
    public boolean addExecutiveStaffType(ExecutiveStaffType executiveStaffType);

    /**
     * 删除演职人员类型
     * @param executiveStaffType
     * @return
     */
    public void deleteExecutiveStaffType(ExecutiveStaffType executiveStaffType);

    /**
     * 修改演职人员类型
     * @param executiveStaffType
     */
    public void updateExecutiveStaffType(ExecutiveStaffType executiveStaffType) throws Exception;

    /**
     * 查询所有的演职人员类型
     * @return
     */
    public List<ExecutiveStaffType> findExecutiveStaffTypes();
}
