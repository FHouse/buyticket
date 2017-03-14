package org.movie.dao.inf;

import org.movie.entity.Admin;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AdminDao extends BaseDao{
    public List<Admin> findAdmin();
}
