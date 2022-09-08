package com.cga.book.garden.service;

import com.cga.book.garden.pojo.CartItem;

import java.util.List;

public interface CartItemService {
    //插入一条购物车项
    void insertCartItem(CartItem cartItem);

    //获取购物车里的所有购物车项
    List<CartItem> getCartItemList();

    //修改图书购买的数量
    void updateBuyCount(Integer buyCount,Integer cartItemId);

    //修改图书购买的数量
    void updateBuyCount(Integer bookId,CartItem cartItemByBookId);

    //根据id查询购买数量
    CartItem getBuyCountByCartItemId(CartItem cartItemId);

    //根据图书id查询购物车项信息
    CartItem getCartItemByBookId(Integer bookId);

    //展示购物车信息
    List<CartItem> showCartItemList();

    //获取购物车中商品的数量
    Long getCartItemNum();

    //获取合计价格
    Double getTotalPrice();

    //删除一条购物车项
    void delCartItem(Integer id);

    //清空购物车
    void delCartItemList();

    //根据状态获取购物车项信息
    List<CartItem> getCartItemListByStatusZero();

//    CartItem getCartItemByTeaId(Integer bookId);
}
