package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Cart;

public interface CartDAO {
    //插入一条用户信息
    void insertUserId(Integer id);
    //根据用户id查询购物车信息
    Cart getCartByUserId(Integer id);
}
