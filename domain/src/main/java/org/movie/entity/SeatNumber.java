package org.movie.entity;

import javax.persistence.*;

/**
 * 订单座位号实体类
 * Created by Wkz on 2017/2/15.
 */
@Entity
@Table(name="seatnumber")
public class SeatNumber {
    //主键
    private String seatNumberId;
    //座位号
    private String seatNumber;
    //该座位号所在的订单
    private OrderInfo orderInfo;

    @Id
    public String getSeatNumberId() {
        return seatNumberId;
    }
    public void setSeatNumberId(String seatNumberId) {
        this.seatNumberId = seatNumberId;
    }

    @Column
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderinfoid")
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
