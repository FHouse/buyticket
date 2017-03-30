package org.movie.dao.inf;

import org.movie.entity.Users;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersDao extends BaseDao{

    /**
     * 根据用户名查询用户信息
     * @param users
     * @return
     */
    public Users findUserByUserName(Users users);
}
