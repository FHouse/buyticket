package org.movie.action;

import com.opensymphony.xwork2.ActionContext;
import org.movie.entity.Admin;
import org.movie.exception.AdminException;
import org.movie.service.inf.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/3/28.
 */
@Controller("adminAction")
@Scope("prototype")
public class AdminAction {

    //注入service
    @Autowired
    @Qualifier("adminService")
    private AdminService service;

    private Admin admin;
    private List<Admin> list;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    //添加管理员
    public String addAdmin(){
        if(service.addAdmin(admin)){
            return "success";
        }else{
            throw new AdminException("该用户已存在！");
        }
    }

    //删除管理员
    public String deleteAdmin(){
        try {
            service.deleteAdmin(admin);
            return "success";
        } catch (Exception e) {
            throw new AdminException("删除失败，请刷新后重新操作！");
        }
    }

    //修改管理员
    public String updateAdmin(){
        try {
            service.updateAdmin(admin);
            return "success";
        } catch (Exception e) {
            throw new AdminException("该数据已被修改，请刷新后重试！");
        }
    }

    //查询所有管理员
    public String findAdmins(){
        list = service.findAdmins();
        return "success";
    }

    //管理员登录
    public String adminLogin(){
        try{
            Admin admin1 = service.adminLogin(admin);
            if(admin1.getAdminPassword().equals(admin.getAdminPassword())){
                ActionContext.getContext().getSession().put("adminName",admin1.getAdminName());
            }else{
                throw new AdminException("用户名或密码不正确！");
            }
            return "success";
        }catch(Exception e){
            throw e;
        }
    }
}
