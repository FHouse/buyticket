package org.movie.service.impl;

import org.movie.dao.inf.UsersDao;
import org.movie.entity.Users;
import org.movie.service.inf.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service( "UsersService" )
public class UsersServiceImpl extends BaseServiceImpl implements UsersService{
    private UsersDao dao;
    @Override
    public List<Users> findUsers() {
        return dao.findUsers();
    }
}
