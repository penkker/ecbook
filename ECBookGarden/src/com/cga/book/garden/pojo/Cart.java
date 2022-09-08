package com.cga.book.garden.pojo;

import java.util.List;

public class Cart {

    private Integer id;
    private Double totalPrice;

    private User userId; //1:1
    private List<Book> bookList; //1:n
    private List<CartItem> cartItemList; //1:n
    private CartItem cartItem;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
//        List<CartItem> cartItemLi = new ArrayList<CartItem>();
//        cartItemLi.add(cartItem);
//        cartItemList = cartItemLi;
        this.cartItem = cartItem;
    }

    public Cart() {
    }

    public Cart(Integer id) {
        this.id = id;
    }

    public Cart(Integer id, Double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User userId) {
        this.userId = userId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {

        this.cartItemList = cartItemList;
    }

}
