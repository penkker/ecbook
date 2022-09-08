package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.OrderDAO;
import com.cga.book.garden.pojo.Order;
import com.cga.book.myssm.basedao.BaseDAO;

import java.sql.Date;
import java.util.List;

public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {

    @Override
    public void insertOrderInfo(Order order,String uuidStr) {
        super.executeUpdate("insert into e_order(id,orderNum,orderTime,payTime,orderStatus,sendStatus,userId,cartItemId) values(?,?,?,?,?,?,?,?)",0,uuidStr,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),0,0,order.getUser().getId(),order.getCartItemId().getId());
    }

    @Override
    public List<Order> getOrderList() {
        return super.executeQuery("select * from e_order");
    }

    @Override
    public Order getOrderByUUID(String uuid) {
        return super.load("select id,orderNum,orderTime,payTime,orderStatus,sendStatus,userId from e_order where orderNum = ?",uuid);
    }

    @Override
    public void delOrderByCartItemId(Integer id) {
        super.executeUpdate("delete from e_order where cartItemId = ?",id);
    }

    @Override
    public void delOrderList() {
        super.executeUpdate("delete from e_order");
    }

}
