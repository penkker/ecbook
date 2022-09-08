package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailDAO {

    //插入一条订单详情信息
    void insertOrderDetail(OrderDetail orderDetail);

    //获取所有订单详情信息
    List<OrderDetail> getOrderDetailList();
}
