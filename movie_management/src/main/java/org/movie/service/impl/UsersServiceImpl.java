package org.movie.service.impl;

import org.movie.dao.inf.UsersDao;
import org.movie.entity.Users;
import org.movie.service.inf.UsersService;
import org.movie.util.CheckVer;
import org.movie.util.UUIDUtil;
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

    @Override
    public String addUser(Users users) {
        users.setUsersId(UUIDUtil.getUUID());
        try{
            dao.findUserByUserName(users);
            return "该用户名或电话号码已存在！";
        }catch(Exception e){
            dao.save(users);
            return "添加成功！";
        }
    }

    @Override
    public void deleteUser(Users users) {
        //未完善
    }

    @Override
    public void updateUser(Users users) throws Exception {
        Users users1 = (Users) dao.findById(Users.class,users.getUsersId());
        users1 = CheckVer.checkVer(users1,users,Users.class);
        dao.update(users1);
    }

    @Override
    public List<Users> findUsers() {
        return dao.findAll(Users.class);
    }
}
