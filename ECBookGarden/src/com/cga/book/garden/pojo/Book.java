package com.cga.book.garden.pojo;

public class Book {

    private Integer id;
    private String bookName;
    private String bookImg;
    private Double price;  //进价
    private Integer spareCount;
    private String bookTypeA;
    private String bookTypeB;
    private String bookTypeC;
    private String bookNum;
    private Double sellPrice;
    private String enterDate;
    private String exportDate;
    private Double profit;
    private String status;
    private String sellCount;
    private Integer enterCount;
    private String loveTime;
    private Double random;

    private User userId; //n:1
    private Cart cartId; //n:1
    private Order orderId; //n:1

    private Double totalPrice;
    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String bookName, String bookImg, Double price, Integer spareCount, String bookTypeA, String bookTypeB, String bookTypeC) {
        this.id = id;
        this.bookName = bookName;
        this.bookImg = bookImg;
        this.price = price;
        this.spareCount = spareCount;
        this.bookTypeA = bookTypeA;
        this.bookTypeB = bookTypeB;
        this.bookTypeC = bookTypeC;
    }

    public Book(Integer id, String bookName, Double price) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
    }

    public String getSellCount() {
        return sellCount;
    }

    public void setSellCount(String sellCount) {
        this.sellCount = sellCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getEnterCount() {
        return enterCount;
    }

    public void setEnterCount(Integer enterCount) {
        this.enterCount = enterCount;
    }

    //进货数量减去卖出数量
    public Integer getSpareCount() {
        Integer tempSpareCount = this.enterCount - Integer.valueOf(this.sellCount);

        return tempSpareCount;
    }

    public void setSpareCount(Integer spareCount) {
        this.spareCount = spareCount;
    }

    public String getBookTypeA() {
        return bookTypeA;
    }

    public void setBookTypeA(String bookTypeA) {
        this.bookTypeA = bookTypeA;
    }

    public String getBookTypeB() {
        return bookTypeB;
    }

    public void setBookTypeB(String bookTypeB) {
        this.bookTypeB = bookTypeB;
    }

    public String getBookTypeC() {
        return bookTypeC;
    }

    public void setBookTypeC(String bookTypeC) {
        this.bookTypeC = bookTypeC;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cartId;
    }

    public void setCart(Cart cartId) {
        this.cartId = cartId;
    }

    public Order getOrder() {
        return orderId;
    }

    public void setOrder(Order orderId) {
        this.orderId = orderId;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoveTime() {
        return loveTime;
    }

    public void setLoveTime(String loveTime) {
        this.loveTime = loveTime;
    }

    public Double getRandom() {
        return random;
    }

    public void setRandom(Double random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", price=" + price +
                '}';
    }
}
