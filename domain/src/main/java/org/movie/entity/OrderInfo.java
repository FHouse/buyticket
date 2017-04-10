package org.movie.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * 订单信息
 * Created by Wkz on 2017/2/9.
 */
@Entity
@Table(name="orderinfo")
public class OrderInfo {
    //主键
    private String orderInfoId;
    //支付状态
    private String paymentState = "未支付";
    //下单时间
    private Date orderTime;
    //乐观锁版本号
    private int ver = 1;
    //下单电影的场次
    private FilmScreenings filmScreenings;
    //下单的人
    private Users users;
    //座位号
    private Set<SeatNumber> seatNumbers;

    @Id
    public String getOrderInfoId() {
        return orderInfoId;
    }
    public void setOrderInfoId(String orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    @Column
    public String getPaymentState() {
        return paymentState;
    }
    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    @Column
    public Date getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Column
    public int getVer() {
        return ver;
    }
    public void setVer(int ver) {
        this.ver = ver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filmScreeningsId")
    public FilmScreenings getFilmScreenings() {
        return filmScreenings;
    }
    public void setFilmScreenings(FilmScreenings filmScreenings) {
        this.filmScreenings = filmScreenings;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usersid")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "orderInfo",fetch = FetchType.LAZY)
    public Set<SeatNumber> getSeatNumbers() {
        return seatNumbers;
    }
    public void setSeatNumbers(Set<SeatNumber> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}
