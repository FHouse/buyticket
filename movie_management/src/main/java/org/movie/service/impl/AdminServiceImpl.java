package org.movie.service.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.entity.Admin;
import org.movie.exception.AdminException;
import org.movie.service.inf.AdminService;
import org.movie.util.CheckVer;
import org.movie.util.ThisTime;
import org.movie.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

    //注入dao
    @Autowired
    @Qualifier("adminDao")
    private AdminDao dao;

    @Override
    public boolean addAdmin(Admin admin){
        admin.setAdminId(UUIDUtil.getUUID());
        try{
            dao.findAdminByName(admin);
            return false;
        }catch (Exception e){
            dao.save(admin);
            return true;
        }
    }

    @Override
    public void deleteAdmin(Admin admin) throws Exception {
        Admin admin1 = (Admin) dao.findById(Admin.class,admin.getAdminId());
        admin1 = CheckVer.checkVer(admin1,admin,Admin.class);
        dao.delete(admin1);
    }

    @Override
    public void updateAdmin(Admin admin) throws Exception {
        Admin admin1 = (Admin) dao.findById(Admin.class,admin.getAdminId());
        admin1 = CheckVer.checkVer(admin1,admin,Admin.class);
        dao.update(admin1);
    }

    @Override
    public List<Admin> findAdmins() {
        return dao.findAll(Admin.class);
    }

    @Override
    public Admin adminLogin(Admin admin) {
        try{
            return dao.findAdminByName(admin);
        }catch (Exception e){
            throw new AdminException("用户名或密码不正确！");
        }
    }
}
