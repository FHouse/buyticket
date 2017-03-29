package org.movie.action;

import com.opensymphony.xwork2.ActionContext;
import org.movie.entity.Admin;
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
    private String message;
    private List<Admin> list;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    //添加管理员
    public String addAdmin(){
        message = service.addAdmin(admin);
        return "success";
    }

    //删除管理员
    public String deleteAdmin(){
        try {
            service.deleteAdmin(admin);
            message = "删除成功！";
        } catch (Exception e) {
            e.printStackTrace();
            message = "删除失败，请刷新后重新操作！";
        }
        return "success";
    }

    //修改管理员
    public String updateAdmin(){
        try {
            service.updateAdmin(admin);
            message = "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            message = "修改失败，请刷新后重新操作！";
        }
        return "success";
    }

    //查询所有管理员
    public String findAdmins(){
        list = service.findAdmins();
        return "success";
    }

    //管理员登录
    public String adminLogin(){
        message = service.adminLogin(admin);
        if(!message.equals("用户名或密码不正确！")){
            ActionContext.getContext().getSession().put("adminName",message);
        }
        return "success";
    }
}
