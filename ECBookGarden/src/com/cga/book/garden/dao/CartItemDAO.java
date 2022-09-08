package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.CartItem;

import java.util.List;

public interface CartItemDAO {

    //插入一条购物车项
    void insertCartItem(CartItem cartItem);

    //获取购物车里所有的购物车项
    List<CartItem> getCartItemList();

    //修改图书购买数量
    void updateBuyCount(Integer buyCount,Integer cartItemId);

    //修改图书购买的数量
    void updateBuyCount(Integer bookId,CartItem cartItemByBookId);

    //根据购物车项id查询购买数量
    CartItem getBuyCountByCartItemId(CartItem cartItemId);

    //根据图书id查询购物车项信息
    CartItem getCartItemByBookId(Integer bookId);

    //获取购物车中商品的数量
    Long getCartItemNum();

    //根据id删除指定购物车项信息
    void delCartItem(Integer id);

    //清空购物车项数据
    void delCartItemList();

    //根据状态获取购物车项信息
    List<CartItem> getCartItemListByStatusZero();

//    //根据id获取茶购物车项信息
//    CartItem getCartItemByTeaId(Integer bookId);
}
