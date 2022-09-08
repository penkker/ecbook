package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.CartItem;
import com.cga.book.garden.pojo.Order;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.CartItemService;
import com.cga.book.garden.service.OrderDetailService;
import com.cga.book.garden.service.OrderService;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class OrderController {

    private CartItemService cartItemService;
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    public String checkOut(HttpSession session){

        List<CartItem> cartItemList = cartItemService.showCartItemList();
        User user = (User)session.getAttribute("currUser");

        //插入订单数量
        //购物车项种buyCount数量即为订单数量
        for(CartItem cartItem : cartItemList){

            String uuidStr = UUID.randomUUID().toString();
            Date date =  new Date(System.currentTimeMillis());
            String uuidCode = date.toString() + uuidStr;

            orderService.insertOrderInfo(new Order(user,cartItem),uuidCode);
            Order orderByUUID = orderService.getOrderByUUID(uuidCode);
            orderByUUID.setCartItemId(cartItem);

            Integer buyCount = cartItem.getBuyCount();
            cartItem.setOrderUUID(uuidCode);
            cartItem.setOrderDate(new Date(System.currentTimeMillis()));


        }

        session.setAttribute("cartItemListOrder",cartItemList);

        //删除订单和购物车项信息
        cartItemService.delCartItemList();

        return "order/order";

    }

}
