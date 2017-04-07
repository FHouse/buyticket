package org.movie.dao.inf;

import org.movie.entity.Users;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersDao extends BaseDao{
    public Users findUserByUserName(Users users);
}
