package org.movie.dao.inf;

import org.movie.entity.Admin;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AdminDao extends BaseDao{

    /**
     * 根据用户名查询该用户信息
     * @param admin
     * @return
     */
    public Admin findAdminByName(Admin admin);
}
