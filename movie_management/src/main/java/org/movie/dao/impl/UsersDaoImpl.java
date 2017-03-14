package org.movie.dao.impl;

import org.movie.dao.inf.UsersDao;
import org.movie.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("UsersDao")
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao{
    @Override
    public List<Users> findUsers() {
        String jpql = "from Users";
        return em.createQuery(jpql).getResultList();
    }
}
