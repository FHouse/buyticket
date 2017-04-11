package org.movie.dao.inf;

import org.movie.entity.Users;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersDao extends BaseDao{
    public List<Users> findUserByUserName(Users users);
}
