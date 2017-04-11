package org.movie.dao.impl;

import org.movie.dao.inf.UsersDao;
import org.movie.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao{
    @Override
    public List<Users> findUserByUserName(Users users) {
        String jpql = "from Users s where s.userName = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,users.getUserName());
        return query.getResultList();
    }
}
