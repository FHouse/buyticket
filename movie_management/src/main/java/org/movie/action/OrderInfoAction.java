package org.movie.action;

import org.movie.entity.OrderInfo;
import org.movie.exception.OrderInfoException;
import org.movie.service.inf.OrderInfoService;
import org.movie.util.PageBean;
import org.movie.util.RelieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Describe
 * Created by Wkz on 2017/4/10.
 */
@Controller("orderInfoAction")
@Scope("prototype")
public class OrderInfoAction {

    //注入service
    @Autowired
    @Qualifier("orderInfoService")
    private OrderInfoService service;

    private OrderInfo orderInfo;
    private PageBean pageBean;
    private String message;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //修改订单
    public String updateOrderInfo(){
        try{
            service.updateOrderInfo(orderInfo);
            return "success";
        }catch(Exception e){
            throw new OrderInfoException("修改失败，刷新后重试！");
        }
    }

    //删除订单
    public String deleteOrderInfo(){
        try{
            service.deleteOrderInfo(orderInfo);
            return "success";
        }catch(Exception e){
            throw new OrderInfoException("删除失败！");
        }
    }

    //根据电影id查询该电影下的所有订单
    public String findOrderInfoByFilmId(){
        pageBean = service.findOrderInfoByFilmId(pageBean,orderInfo.getFilmScreenings().getFilmInfo());
        for (Object o:pageBean.getList()) {
            RelieveUtil.relieve(o);
        }
        return "success";
    }
}
