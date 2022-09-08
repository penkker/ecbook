package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Order;

import java.util.List;

public interface OrderService {

    //插入一条订单信息
    void insertOrderInfo(Order order,String uuidCode);

    //获取所有订单信息
    List<Order> getOrderList();

    //根据订单号查询订单信息
    Order getOrderByUUID(String uuid);

    //根据cartItemId删除指定订单信息
    void delOrderByCartItemId(Integer id);

    //删除所有订单信息
    void delOrderList();

}
