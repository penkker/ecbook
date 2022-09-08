package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.OrderDetailDAO;
import com.cga.book.garden.pojo.OrderDetail;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class OrderDetailDAOImpl extends BaseDAO<OrderDetail> implements OrderDetailDAO {
    @Override
    public void insertOrderDetail(OrderDetail orderDetail) {
        super.executeUpdate("insert into e_orderdetail values(?,?,?)",0,orderDetail.getBuyCount(),orderDetail.getOrderId().getId());
    }

    @Override
    public List<OrderDetail> getOrderDetailList() {
        return super.executeQuery("select * from e_orderdetail");
    }
}
