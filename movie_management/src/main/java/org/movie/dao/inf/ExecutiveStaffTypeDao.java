package org.movie.dao.inf;

import org.movie.entity.ExecutiveStaffType;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffTypeDao extends BaseDao{

    /**
     * 根据演职人员类型名称查询演职人员类型
     * @return
     */
    public ExecutiveStaffType findESTypeByName(ExecutiveStaffType executiveStaffType);
}
