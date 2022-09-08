package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.CartItemDAO;
import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.CartItem;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.service.*;

import java.math.BigDecimal;
import java.util.List;

public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private BookService bookService;
    private OrderService orderService;
    private TeaService teaService;
    private HotBookService hotBookService;

    @Override
    public void insertCartItem(CartItem cartItem) {
        cartItemDAO.insertCartItem(cartItem);
    }

    @Override
    public List<CartItem> getCartItemList() {
        return cartItemDAO.getCartItemList();
    }

    @Override
    public void updateBuyCount(Integer buyCount,Integer cartItemId) {
        cartItemDAO.updateBuyCount(buyCount,cartItemId);
    }

    @Override
    public void updateBuyCount(Integer bookId,CartItem cartItemByBookId) {
        cartItemDAO.updateBuyCount(bookId,cartItemByBookId);
    }

    @Override
    public CartItem getBuyCountByCartItemId(CartItem cartItemId) {
        return cartItemDAO.getBuyCountByCartItemId(cartItemId);
    }

    @Override
    public CartItem getCartItemByBookId(Integer bookId) {
        return cartItemDAO.getCartItemByBookId(bookId);
    }

    @Override
    public List<CartItem> showCartItemList() {
        List<CartItem> cartItemList = getCartItemList();

        for(CartItem cartItem : cartItemList){
            Integer id = cartItem.getBookId().getId();
            int newId = id;
            Book book = null;
            HotBook hotBook = null;
            Double price;

            if(id > 330){

                book = bookService.getBookById(id);
                price = book.getPrice();

            }else{

                hotBook = hotBookService.getHotBookById(id);
                price = hotBook.getPrice();

            }

            Double buyCount = Double.valueOf(cartItem.getBuyCount());
            BigDecimal bigPrice = new BigDecimal(price);
            BigDecimal bigButCount = new BigDecimal(buyCount);
            BigDecimal totalPrice = bigPrice.multiply(bigButCount);
            double value = totalPrice.doubleValue();

            cartItem.setTotalPrice(value);
            cartItem.setBookId(book);
            cartItem.setHotBookId(hotBook);
        }

        return cartItemList;
    }

    @Override
    public Long getCartItemNum() {
        return cartItemDAO.getCartItemNum();
    }

    @Override
    public Double getTotalPrice() {

        List<CartItem> cartItemList = showCartItemList();
        double sum = 0.0;
        for (CartItem cartItem : cartItemList) {

            sum = sum + cartItem.getTotalPrice();
        }

        return sum;

    }

    @Override
    public void delCartItem(Integer id) {

        //考虑到数据库外键关联
        orderService.delOrderByCartItemId(id);
        cartItemDAO.delCartItem(id);

    }

    @Override
    public void delCartItemList() {

        //考虑到外键问题
        orderService.delOrderList();
        cartItemDAO.delCartItemList();

    }

    @Override
    public List<CartItem> getCartItemListByStatusZero() {
        return cartItemDAO.getCartItemListByStatusZero();
    }

//    @Override
//    public CartItem getCartItemByTeaId(Integer bookId) {
//        return cartItemDAO.getCartItemByTeaId(bookId);
//    }


}
