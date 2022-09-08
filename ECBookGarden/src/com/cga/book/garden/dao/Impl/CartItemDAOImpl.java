package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.CartItemDAO;
import com.cga.book.garden.pojo.CartItem;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void insertCartItem(CartItem cartItem) {
        super.executeUpdate("insert into e_cart_item(id,buyCount,buyTime,bookId,userId,bookStatus) values(?,?,?,?,?,?)",0,cartItem.getBuyCount(),cartItem.getBuyTime(),cartItem.getBookId().getId(),cartItem.getUserId().getId(),0);
    }

    @Override
    public List<CartItem> getCartItemList() {
        return super.executeQuery("select * from e_cart_item");
    }

    @Override
    public void updateBuyCount(Integer buyCount,Integer cartItemId) {
        super.executeUpdate("update e_cart_item set buyCount = ? where id = ?",buyCount,cartItemId);
    }

    @Override
    public void updateBuyCount(Integer bookId,CartItem cartItemByBookId) {
        super.executeUpdate("update e_cart_item set buyCount = ? where bookId = ?",cartItemByBookId.getBuyCount() + 1,bookId);
    }

    @Override
    public CartItem getBuyCountByCartItemId(CartItem cartItemId) {
        return super.load("select buyCount from e_cart_item where id = ?",cartItemId.getId());
    }

    @Override
    public CartItem getCartItemByBookId(Integer bookId) {
        return super.load("select id,buyCount,buyTime,bookId,userId from e_cart_item where bookId = ?",bookId);
    }

    @Override
    public Long getCartItemNum() {
        return (Long) (super.executeComplexQuery("select count(*) from e_cart_item")[0]);
    }

    @Override
    public void delCartItem(Integer id) {
        super.executeUpdate("delete from e_cart_item where id = ?",id);
    }

    @Override
    public void delCartItemList() {
        super.executeUpdate("delete from e_cart_item");
    }

    @Override
    public List<CartItem> getCartItemListByStatusZero() {
        return super.executeQuery("select * from e_cart_item where bookStatus = ?",0);
    }

}
