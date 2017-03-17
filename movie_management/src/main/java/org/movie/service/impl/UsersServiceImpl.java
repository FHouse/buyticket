package org.movie.service.impl;

import org.movie.dao.inf.ExecutiveStaffTypeDao;
import org.movie.dao.inf.UsersDao;
import org.movie.entity.Users;
import org.movie.service.inf.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{
    //注入dao
    @Autowired
    @Qualifier("usersDao")
    private UsersDao dao;
}