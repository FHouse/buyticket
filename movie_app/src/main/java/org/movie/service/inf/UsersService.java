package org.movie.service.inf;

import org.movie.entity.Users;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersService{
    public void addUser(Users users);
    public void updataUser(Users users);
    public Users findUserByUserName(Users users);
}
