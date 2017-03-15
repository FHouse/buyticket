package org.movie.service.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.service.inf.AdminService;
import org.movie.util.ThisTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/3/14.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl extends BaseServiceImpl implements AdminService{

    //注入dao
    @Autowired
    @Qualifier("adminDao")
    private AdminDao dao;

    public static void main(String[] args) {
        System.out.println(ThisTime.getTisTime());
    }
}
