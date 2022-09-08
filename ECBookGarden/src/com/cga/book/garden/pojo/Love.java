package com.cga.book.garden.pojo;

public class Love {

    private Integer id;
    private String loveTime;
    private Book bookId;
    private Tea teaId;
    private String loveImg;
    private String lovePrice;
    private String loveName;
    private Integer tempId;
    private String type;
    private Integer count;
    private HotBook hotBook;


    public Love() {
    }

    public Love(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoveTime() {
        return loveTime;
    }

    public void setLoveTime(String loveTime) {
        this.loveTime = loveTime;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Tea getTeaId() {
        return teaId;
    }

    public void setTeaId(Tea teaId) {
        this.teaId = teaId;
    }

    public String getLoveImg() {
        return loveImg;
    }

    public void setLoveImg(String loveImg) {
        this.loveImg = loveImg;
    }

    public String getLovePrice() {
        return lovePrice;
    }

    public void setLovePrice(String lovePrice) {
        this.lovePrice = lovePrice;
    }

    public String getLoveName() {
        return loveName;
    }

    public void setLoveName(String loveName) {
        this.loveName = loveName;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public HotBook getHotBook() {
        return hotBook;
    }

    public void setHotBook(HotBook hotBook) {
        this.hotBook = hotBook;
    }
}
