package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.OrderDetailDAO;
import com.cga.book.garden.pojo.OrderDetail;
import com.cga.book.garden.service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailDAO orderDetailDAO;

    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {

        orderDetailDAO.insertOrderDetail(orderDetail);

    }

    @Override
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailDAO.getOrderDetailList();
    }
}
