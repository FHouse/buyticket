package org.movie.service.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.entity.Admin;
import org.movie.service.inf.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "AdminService" )
public class AdminServiceImpl extends BaseServiceImpl implements AdminService{
    private AdminDao dao;
    @Override
    public List<Admin> findAdmin() {
        return dao.findAdmin();
    }
}
