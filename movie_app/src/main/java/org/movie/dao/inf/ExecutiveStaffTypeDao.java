package org.movie.dao.inf;

import org.movie.entity.ExecutiveStaffType;

/**
 * Created by admin on 2017/3/14.
 */
public interface ExecutiveStaffTypeDao extends BaseDao{
    public ExecutiveStaffType findESTypeByName(ExecutiveStaffType executiveStaffType);
}
