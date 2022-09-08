package com.cga.book.garden.pojo;

import java.util.List;

public class Order {

    private Integer id;
    private String orderNum;
    private String orderTime;
    private String payTime;
    private Integer orderStatus;
    private Integer sendStatus;

    private User userId; //n:1
    private List<OrderDetail> orderDetailList; //1:n
    private List<Book> bookList; //1:n
    private CartItem cartItemId;

    public Order() {
    }

    public Order(User userId, CartItem cartItemId) {
        this.userId = userId;
        this.cartItemId = cartItemId;
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(Integer id, String orderNum, String orderTime, String payTime, Integer orderStatus, Integer sendStatus) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.payTime = payTime;
        this.orderStatus = orderStatus;
        this.sendStatus = sendStatus;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public CartItem getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(CartItem cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = user;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


}
