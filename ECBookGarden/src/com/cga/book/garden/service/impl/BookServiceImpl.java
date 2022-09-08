package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.BookDAO;
import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.service.BookService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public List<Book> getBookListByKeyName(String bookName) {

        List<Book> bookListByKeyName = bookDAO.getBookListByKeyName(bookName);

        double value = 0;
        for (Book book : bookListByKeyName) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

            Random random = new Random();
            Double rans = random.nextInt(20) + 10 + book.getPrice();
            book.setRandom(rans);

        }
        return bookListByKeyName;
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public List<Book> getBookByBookNum(String bookNum) {
        List<Book> bookByBookNum = bookDAO.getBookByBookNum(bookNum);

        double value = 0;
        for (Book book : bookByBookNum) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

        }
        return bookByBookNum;
    }

    @Override
    public List<Book> getBookListByDate(String enterDate, String exportDate) {
        List<Book> bookListByDate = bookDAO.getBookListByDate(enterDate, exportDate);

        double value = 0;
        for (Book book : bookListByDate) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

        }
        return bookListByDate;
    }

    @Override
    public List<Book> getIsOrNotBookList(String bookNum, String bookName) {
        List<Book> bookList = new ArrayList<>();

        if(bookName != null || !"".equals(bookNum)){

            if(bookName != null){

                bookList = getBookListByKeyName(bookName);
            } else if (!"".equals(bookNum)){

                bookList = getBookByBookNum(bookNum);
            }else if (bookName != null && !"".equals(bookNum)){

                return null;
            }

        }
        return bookList;
    }

    @Override
    public void delBookItem(Integer bookId) {
        bookDAO.delBookItem(bookId);
    }

    @Override
    public Long getBookCount() {
        return bookDAO.getBookCount();
    }

    @SuppressWarnings("测试设置总价方法")
    @Override
    public void setTotalPrice() {

        List<Book> bookList = getBookList();
        double value = 0;
        for (Book book : bookList) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

        }


    }

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public List<Book> getBook(String bookNum, String middleArg, String bookName) {
        List<Book> bookList = null;

        if (middleArg != null) {

            String[] splitMiddle = middleArg.split(",");
            //    System.out.println(splitMiddle.length);
            List<String> strMiddle = Arrays.asList(splitMiddle);

            System.out.println("strMiddle.size() = " + strMiddle.size());

            if ("".equals(bookNum) && bookName == null) {

                if (strMiddle.size() == 2) {

                    bookList = getBookListByDate(splitMiddle[0], splitMiddle[1]);
                }
            } else {

                bookList = getIsOrNotBookList(bookNum,bookName);
            }
        }else{

            bookList = getIsOrNotBookList(bookNum,bookName);
        }

        return bookList;
    }


    @Override
    public List<Book> getTradeInfo(String bookNum, String middleArg, String bookName) {
        List<Book> bookList = null;

        if (middleArg != null) {

            String[] splitMiddle = middleArg.split(",");
            //    System.out.println(splitMiddle.length);
            List<String> strMiddle = Arrays.asList(splitMiddle);

            System.out.println("strMiddle.size() = " + strMiddle.size());

            if ("".equals(bookNum) && bookName == null) {

                if (strMiddle.size() == 2) {

                    bookList = getTradeInfoByDate(splitMiddle[0], splitMiddle[1]);
                }
            } else {

                bookList = getIsOrNotBookList(bookNum,bookName);
            }
        }else{

            bookList = getIsOrNotBookList(bookNum,bookName);
        }

        return bookList;
    }

    @Override
    public List<Book> getTradeInfoByDate(String sellPre, String sellLast) {
        List<Book> bookListByDate = bookDAO.getTradeInfoByDate(sellPre, sellLast);

        double value = 0;
        for (Book book : bookListByDate) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

        }
        return bookListByDate;
    }

    @Override
    public void insertBook(Book book) {
        bookDAO.insertBook(book);
    }

    @Override
    public List<Book> getBookByLimitId(Integer left, Integer right) {

        return bookDAO.getBookByLimitId(left,right);
    }

    @Override
    public List<Book> getBookListByBookType(String bookType) {

        List<Book> bookListByBookType = bookDAO.getBookListByBookType(bookType);

        double value = 0;
        for (Book book : bookListByBookType) {
            double sellPrice = book.getSellPrice();
            String sellCount = book.getSellCount();

            BigDecimal bigSellPrice = new BigDecimal(sellPrice);
            BigDecimal bigSellCount = new BigDecimal(sellCount);

            BigDecimal multiply = bigSellPrice.multiply(bigSellCount);
            value = multiply.doubleValue();
            book.setTotalPrice(value);

            Random random = new Random();
            Double rans = random.nextInt(20) + 10 + book.getPrice();
            book.setRandom(rans);

        }
        return bookListByBookType;
    }
}
