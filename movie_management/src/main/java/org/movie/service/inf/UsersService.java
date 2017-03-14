package org.movie.service.inf;

import org.movie.entity.Users;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersService extends BaseService{
    public List<Users> findUsers();
}
