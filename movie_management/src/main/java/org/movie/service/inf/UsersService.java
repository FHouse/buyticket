package org.movie.service.inf;

import org.movie.entity.Users;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface UsersService{

    /**
     * 添加用户，可用于注册
     * @param users
     */
    public boolean addUser(Users users);

    /**
     * 删除用户
     * @param users
     */
    public void deleteUser(Users users);

    /**
     * 修改用户
     * @param users
     */
    public void updateUser(Users users) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    public List<Users> findUsers();

}
