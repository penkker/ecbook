package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.CartDAO;
import com.cga.book.garden.pojo.Cart;
import com.cga.book.myssm.basedao.BaseDAO;

public class CartDAOImpl extends BaseDAO<Cart> implements CartDAO {
    @Override
    public void insertUserId(Integer id) {
        super.executeUpdate("update e_cart set userId = ?",id);
    }

    @Override
    public Cart getCartByUserId(Integer id) {
        return super.load("select ");   //
    }
}
