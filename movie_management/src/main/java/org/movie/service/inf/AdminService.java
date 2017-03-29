package org.movie.service.inf;

import org.movie.entity.Admin;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */
public interface AdminService{

    /**
     * 添加管理员
     * @param admin
     */
    public String addAdmin(Admin admin);

    /**
     * 删除管理员
     * @param admin
     */
    public void deleteAdmin(Admin admin) throws Exception;

    /**
     * 修改管理员
     * @param admin
     */
    public void updateAdmin(Admin admin) throws Exception;

    /**
     * 查询所有管理员
     * @return
     */
    public List<Admin> findAdmins();

    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    public String adminLogin(Admin admin);
}
