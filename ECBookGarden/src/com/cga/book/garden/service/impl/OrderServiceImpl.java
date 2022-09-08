package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.OrderDAO;
import com.cga.book.garden.pojo.Order;
import com.cga.book.garden.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Override
    public void insertOrderInfo(Order order,String uuidCode) {
        orderDAO.insertOrderInfo(order,uuidCode);
    }

    @Override
    public List<Order> getOrderList() {
        return orderDAO.getOrderList();
    }

    @Override
    public Order getOrderByUUID(String uuid) {
        return orderDAO.getOrderByUUID(uuid);
    }

    @Override
    public void delOrderByCartItemId(Integer id) {
        orderDAO.delOrderByCartItemId(id);
    }

    @Override
    public void delOrderList() {
        orderDAO.delOrderList();
    }
}
