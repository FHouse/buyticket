package org.movie.service.inf;
import org.movie.entity.Users;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersService{
    public boolean addUser(Users users);
    public void updateUser(Users users) throws Exception;
    public List<Users> findUserByUserName(Users users);
}
