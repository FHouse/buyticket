package org.movie.action;

import org.movie.entity.Users;
import org.movie.service.inf.UsersService;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by admin on 2017/3/31.
 */
@Controller("usersAction")
@Scope("prototype")
public class UsersAction {

    //注入service
    @Autowired
    @Qualifier("usersService")
    private UsersService service;

    private Users users;
    private String message;
    private List<Users> list;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Users> getList() {
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }

    //添加用户
    public String addUser(){
        message = service.addUser(users);
        return "success";
    }

    //修改用户
    public String updateUser(){
        try {
            service.updataUser(users);
            message = "修改成功！";
        } catch (Exception e) {
            e.printStackTrace();
            message = "该用户信息已被修改，请刷新后重试！";
        }
        return "success";
    }

    //查询指定用户
    public String findUserByUserName(){
        list = service.findUserByUserName(users.getUserName());
        for(Users users:list){
            RelieveUtil.relieve(users);
        }
        return  "success";
    }
}
