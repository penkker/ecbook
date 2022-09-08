package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.CartItem;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.BookService;
import com.cga.book.garden.service.CartItemService;
import com.cga.book.garden.service.HotBookService;
import com.cga.book.garden.service.TeaService;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

public class CartController {

    private BookService bookService;
    private CartItemService cartItemService;
    private TeaService teaService;
    private HotBookService hotBookService;

    public String addCartItem(Integer bookId,String log, HttpSession session){
        Book book = bookService.getBookById(bookId);
        User currUser = (User)session.getAttribute("currUser");
        CartItem cartItemByBookId = cartItemService.getCartItemByBookId(bookId);
        if(cartItemByBookId != null){

            cartItemService.updateBuyCount(bookId,cartItemByBookId);

            if("keji".equals(log)){

                return "search/keji_class";
            }else if("wenx".equals(log)){

                return "search/wenx_class";
            }else if("novel".equals(log)){

                return "search/novel_class";
            }else if("life".equals(log)){

                return "search/life_class";
            }else {

                return "search/bookclass";
            }

        }

        //存入一条购物车项信息
        Integer idUser = currUser.getId();
        Integer idBook = book.getId();
        CartItem cartItem = new CartItem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化
        String format = sdf.format(new java.util.Date());

        cartItem.setBuyCount(1);
        cartItem.setBuyTime(format);
        cartItem.setBookId(new Book(book.getId()));
        cartItem.setUserId(new User(currUser.getId()));
        cartItemService.insertCartItem(cartItem);

        //让存入的购物车项能渲染到前端页面上
        //thymeleaf渲染
//        List<CartItem> cartItemList = cartItemService.getCartItemList();
//        for (CartItem cartItems : cartItemList){
//
//            Book bookItem = bookService.getBookById(cartItems.getBookId().getId());
//            cartItems.setBookImg(bookItem.getBookImg());
//            cartItems.setBookName(bookItem.getBookName());
//            cartItems.setPrice(bookItem.getPrice());
//        }
//        session.setAttribute("cartItemList",cartItemList);

        if("keji".equals(log)){

            return "search/keji_class";
        }else if("wenx".equals(log)){

            return "search/wenx_class";
        }else if("novel".equals(log)){

            return "search/novel_class";
        }else if("life".equals(log)){

            return "search/life_class";
        }

        return "search/bookclass";

    }

    //查询购物车里所有的信息使用vue
    public String showCartItemList(HttpSession session){

        List<CartItem> cartItemList = cartItemService.showCartItemList();

//        session.setAttribute("vueCartItemList",cartItemList);
        Gson gson = new Gson();
        String json = gson.toJson(cartItemList);

        return "json:" + json;

    }

    //鼠标点击想购买的数量变化
    public String addCount(Integer buyCount,Integer cartItemId,HttpSession session){

        cartItemService.updateBuyCount(buyCount, cartItemId);
        CartItem cartItem = cartItemService.getBuyCountByCartItemId(new CartItem(cartItemId));

        List<CartItem> cartItemList = cartItemService.showCartItemList();

        Gson gson = new Gson();
        String json = gson.toJson(cartItemList);

        return "json:" + json;
    }

    //获取购物车中商品数量
    public String getCartItemNums(){
        Long cartItemNum = cartItemService.getCartItemNum();

//        System.out.println(cartItemNum);  打印商品数量
        Gson gson = new Gson();
        String json = gson.toJson(cartItemNum);

        return "json:" + json;
    }

    //获取合计价格
    public String getTotalPrice(){

        Double totalPrice = cartItemService.getTotalPrice();
        Gson gson = new Gson();
        String json = gson.toJson(totalPrice);
        return "json:" + json;

    }

    //删除一条商品信息
    public String delCartItem(Integer id){

        cartItemService.delCartItem(id);

        Gson gson = new Gson();
        String json = gson.toJson("删除成功!");

        return "json:" + json;

    }

    public String cleanCart(){

        cartItemService.delCartItemList();

        Gson gson = new Gson();
        String json = gson.toJson("购物车已清空!");

        return "json:" + json;

    }

    public String addCartItemHotBook(Integer bookId, HttpSession session) {
        HotBook hotBookById = hotBookService.getHotBookById(bookId);
        User currUser = (User) session.getAttribute("currUser");
        CartItem cartItemByBookId = cartItemService.getCartItemByBookId(bookId);
        if (cartItemByBookId != null) {

            cartItemService.updateBuyCount(bookId, cartItemByBookId);

            return "view/view_book";
        }

        //存入一条购物车项信息
        Integer idUser = currUser.getId();
        Integer idHotBook = hotBookById.getId();
        CartItem cartItem = new CartItem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化
        String format = sdf.format(new java.util.Date());

        cartItem.setBuyCount(1);
        cartItem.setBuyTime(format);
        cartItem.setBookId(new Book(hotBookById.getId()));
        cartItem.setUserId(new User(currUser.getId()));
        cartItemService.insertCartItem(cartItem);

        return "view/view_book";
    }
}
