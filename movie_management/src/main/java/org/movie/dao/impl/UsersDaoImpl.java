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
    public Users findUserByUserName(Users users) {
        String jpql = "from Users s where s.userName = ?1 or s.userTel = ?2";
        Query query = em.createQuery(jpql);
        query.setParameter(1,users.getUserName());
        query.setParameter(2,users.getUserTel());
        return (Users) query.getSingleResult();
    }

    @Override
    public Users findUserById(Users users) {
        String jpql = "from Users u left join fetch u.collections left join fetch u.filmComments left join fetch u.orders where u.usersId = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1,users.getUsersId());
        return (Users) query.getSingleResult();
    }
}
