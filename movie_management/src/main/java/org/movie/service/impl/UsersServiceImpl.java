package org.movie.service.impl;

import org.movie.dao.inf.OrderInfoDao;
import org.movie.dao.inf.UsersDao;
import org.movie.entity.*;
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

    //注入订单dao
    @Autowired
    @Qualifier("orderInfoDao")
    private OrderInfoDao orderInfoDao;

    @Override
    public boolean addUser(Users users){
        users.setUsersId(UUIDUtil.getUUID());
        try{
            dao.findUserByUserName(users);
            return false;
        }catch(Exception e){
            dao.save(users);
            return true;
        }
    }

    @Override
    public void deleteUser(Users users) {
        users = dao.findUserById(users);
        //删除该用户的所有想看记录
        for (CollectionInfo ci : users.getCollections()) {
            dao.delete(ci);
        }
        //删除该用户的所有电影评论
        for (FilmComment fc : users.getFilmComments()) {
            dao.delete(fc);
        }
        //删除该用户的所有订单
        for (OrderInfo oi : users.getOrders()) {
            oi = orderInfoDao.findOrderInfoById(oi);
            for (SeatNumber sn:oi.getSeatNumbers()) {
                orderInfoDao.delete(sn);
            }
            dao.delete(oi);
        }
        //删除用户
        dao.delete(users);
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
