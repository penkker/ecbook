package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.CartDAO;
import com.cga.book.garden.pojo.Cart;
import com.cga.book.garden.service.CartService;

public class CartServiceImpl implements CartService {

    private CartDAO cartDAO;

    @Override
    public void insertUserId(Integer id) {
        cartDAO.insertUserId(id);
    }

    @Override
    public Cart getCartByUserId(Integer id) {
        return cartDAO.getCartByUserId(id);
    }
}
