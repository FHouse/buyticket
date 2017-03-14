package org.movie.service.inf;

import org.movie.entity.Admin;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AdminService extends BaseService{
    public List<Admin> findAdmin();
}
