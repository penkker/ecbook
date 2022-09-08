package com.cga.book.garden.pojo;

public class OrderDetail {

    private Integer id;
    private Integer buyCount;

    private Order orderId; //n:1

    public OrderDetail() {
    }

    public OrderDetail(Integer buyCount, Order orderId) {
        this.buyCount = buyCount;
        this.orderId = orderId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public OrderDetail(Integer id) {
        this.id = id;
    }

    public OrderDetail(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }



}
