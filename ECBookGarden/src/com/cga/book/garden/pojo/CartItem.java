package com.cga.book.garden.pojo;

import java.sql.Date;

public class CartItem {

    private Integer id;
    private Integer buyCount;
    private String buyTime;

    private Cart cartId; //n:1
    private User userId;
    private Book bookId;
    private String bookStatus;  //图书状态为1时表示已经删除
    private Tea teaId;

    private String bookImg;
    private String bookName;
    private Double enterPrice;
    private Double totalPrice;  //每一个购物车项总价格
    private Double sumPrice; //合计价格
    private Integer orderNum;
    private String orderUUID;
    private Date orderDate;
    private HotBook hotBookId;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public CartItem(Integer id, Integer buyCount){
        this.id = id;
        this.buyCount = buyCount;
    }

    public String getBookImg() {
        return bookImg;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return enterPrice;
    }

    public void setPrice(Double enterPrice) {
        this.enterPrice = enterPrice;
    }

    public CartItem(Integer buyCount, String buyTime, User userId, Book bookId) {
        this.buyCount = buyCount;
        this.buyTime = buyTime;
        this.userId = userId;
        this.bookId = bookId;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public CartItem() {
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer id, Integer buyCount, String buyTime) {
        this.id = id;
        this.buyCount = buyCount;
        this.buyTime = buyTime;
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

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public Cart getCart() {
        return cartId;
    }

    public void setCart(Cart cartId) {
        this.cartId = cartId;
    }

    public Tea getTeaId() {
        return teaId;
    }

    public void setTeaId(Tea teaId) {
        this.teaId = teaId;
    }

    public Double getEnterPrice() {
        return enterPrice;
    }

    public void setEnterPrice(Double enterPrice) {
        this.enterPrice = enterPrice;
    }

    public HotBook getHotBookId() {
        return hotBookId;
    }

    public void setHotBookId(HotBook hotBookId) {
        this.hotBookId = hotBookId;
    }
}
