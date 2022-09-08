package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.LoveDAO;
import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.pojo.Love;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.garden.service.BookService;
import com.cga.book.garden.service.HotBookService;
import com.cga.book.garden.service.LoveService;
import com.cga.book.garden.service.TeaService;

import java.text.SimpleDateFormat;
import java.util.*;

public class LoveServiceImpl implements LoveService {

    private LoveDAO loveDAO;
    private TeaService teaService;
    private BookService bookService;
    private HotBookService hotBookService;

    @Override
    public List<Love> getGoodsLove(Integer id) {

        int newId = id;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loveTime = sdf.format(new Date());
        Book book = null;
        if(newId > 800000){
            Tea tea = teaService.getTeaById(id);
            tea.setLoveTime(loveTime);
            setLoveTea(tea);

        }else {
            book = bookService.getBookById(id);
            book.setLoveTime(loveTime);
            setLoveBook(book);

            //修改收藏数量
            Love love = loveDAO.getLOveByLoveTime(loveTime);
            Book bookById = bookService.getBookById(love.getBookId().getId());
            String bookTypeA = bookById.getBookTypeA();

            if("文学".equals(bookTypeA)){

                setTypeCount(love,"文学",bookById.getId());
            }else if("科技".equals(bookTypeA)){

                setTypeCount(love,"科技",bookById.getId());
            }else if("生活".equals(bookTypeA)){

                setTypeCount(love,"生活",bookById.getId());
            }else if("小说".equals(bookTypeA)){

                setTypeCount(love,"小说",bookById.getId());
            }

        }
        List<Love> loveList = getLoveList();

        return loveList;
    }

    //设置类型数量
    public void setTypeCount(Love love,String type,Integer bookId){

        loveDAO.setLoveType(type,bookId);

        if(love.getType() != null){

            loveDAO.setLoveTypeCount(1,bookId);
        }else {

            loveDAO.setLoveTypeCountOne(1,bookId);
        }

    }

    //获取所有收藏信息
    @Override
    public List<Love> getLoveList() {
        List<Love> loveList = loveDAO.getLoveList();
        return loveList;
    }

    @Override
    public void delLoveById(Integer id) {
        loveDAO.delLoveById(id);
    }

    @Override
    public Love getLoveById(Integer id) {
        return loveDAO.getLoveById(id);
    }

    @Override
    public Map<String, List<Object>> getRelevantList(List<Love> loveList) {

        List<Object> relevantLoveList = new ArrayList<>();
        Map<String,List<Object>> relevantMap = new HashMap<>();
        List<Book> bookByLimitId = null;
        List<Tea> teaListByLimitId = null;

        int lenBook = 0;
        int lenTea = 0;

        for (Love love : loveList){
            if(love.getBookId().getId() != null){
                lenBook++;
            }
            if(love.getTeaId().getId() != null){
                lenTea++;
            }
        }

        System.out.println("lenBook = " + lenBook);
        System.out.println("lenTea = " + lenTea);

        if(lenBook != 0 && lenTea != 0){
            bookByLimitId = bookService.getBookByLimitId(400, 403);
            teaListByLimitId = teaService.getTeaListByLimitId(853056, 853059);
        }else if(lenBook != 0 || lenTea != 0){
            if(lenBook != 0){
                bookByLimitId = bookService.getBookByLimitId(412, 419);
            }
            if(lenTea != 0){
                teaListByLimitId = teaService.getTeaListByLimitId(853063,853070);
            }
        }

        if(bookByLimitId != null){
            relevantLoveList.addAll(bookByLimitId);
        }

        if(teaListByLimitId != null){
            relevantLoveList.addAll(teaListByLimitId);
        }

        relevantMap.put("relevantData",relevantLoveList);
        return relevantMap;
    }

    @Override
    public List<Love> getGoodsLoveHot(Integer id) {
        int newId = id;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loveTime = sdf.format(new Date());
        HotBook hotBook = null;
        if(newId > 800000){
            Tea tea = teaService.getTeaById(id);
            tea.setLoveTime(loveTime);
            setLoveTea(tea);

        }else {
            hotBook = hotBookService.getHotBookById(id);
            hotBook.setLoveTime(loveTime);
            setLoveHotBook(hotBook);

            //修改收藏数量
//            Love love = loveDAO.getLOveByLoveTime(loveTime);
//            Book bookById = bookService.getBookById(love.getBookId().getId());
//            String bookTypeA = bookById.getBookTypeA();
//
//            if("文学".equals(bookTypeA)){
//
//                setTypeCount(love,"文学",bookById.getId());
//            }else if("科技".equals(bookTypeA)){
//
//                setTypeCount(love,"科技",bookById.getId());
//            }else if("生活".equals(bookTypeA)){
//
//                setTypeCount(love,"生活",bookById.getId());
//            }else if("小说".equals(bookTypeA)){
//
//                setTypeCount(love,"小说",bookById.getId());
//            }

        }
        List<Love> loveList = getLoveList();

        return loveList;
    }

    //向收藏表里添加图书信息
    public void setLoveBook(Book book) {
        loveDAO.setLoveBook(book);

    }

    public void setLoveHotBook(HotBook hotBook){
        hotBookService.setLoveHotBook(hotBook);
    }

    //向收藏表里添加茶信息
    public void setLoveTea(Tea tea){
        loveDAO.setLoveTea(tea);

    }

}
