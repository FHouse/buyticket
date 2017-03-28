package org.movie.service.impl;

import org.movie.dao.inf.AdminDao;
import org.movie.entity.Admin;
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
    public String addAdmin(Admin admin){
        admin.setAdminId(UUIDUtil.getUUID());
        try{
            dao.findAdminByName(admin);
            return "该用户已存在！";
        }catch (Exception e){
            dao.save(admin);
            return "添加成功！";
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
    public String adminLogin(Admin admin) {
        try{
            Admin admin1 = dao.findAdminByName(admin);
            if(admin.getAdminPassword().equals(admin1.getAdminPassword())){
                return admin.getAdminName();
            }else{
                return "用户名或密码不正确！";
            }
        }catch (Exception e){
            return "用户名或密码不正确！";
        }
    }
}
