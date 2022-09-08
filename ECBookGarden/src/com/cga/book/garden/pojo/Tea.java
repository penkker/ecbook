package com.cga.book.garden.pojo;

public class Tea{
    private Integer id;
    private String teaName;
    private String teaPrice;
    private String teaImgName;
    private String teaIntro;
    private String teaDetail;
    private Double teaAddPrice;
    private String type;
    private Integer sellCount;
    private String loveTime;

    public Tea() {
    }

    public Tea(Integer id, String teaName, String teaPrice) {
        this.id = id;
        this.teaName = teaName;
        this.teaPrice = teaPrice;
    }

    public Tea(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(String teaPrice) {

        this.teaAddPrice = Double.parseDouble(teaPrice) + 30;

        this.teaPrice = teaPrice;
    }

    public String getTeaImgName() {
        return teaImgName;
    }

    public void setTeaImgName(String teaImgName) {
        this.teaImgName = teaImgName;
    }

    public String getTeaIntro() {
        return teaIntro;
    }

    public void setTeaIntro(String teaIntro) {
        this.teaIntro = teaIntro;
    }

    public String getTeaDetail() {
        return teaDetail;
    }

    public void setTeaDetail(String teaDetail) {
        this.teaDetail = teaDetail;
    }

    public Double getTeaAddPrice() {
        return teaAddPrice;
    }

    public void setTeaAddPrice(Double teaAddPrice) {

        this.teaAddPrice = teaAddPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public String getLoveTime() {
        return loveTime;
    }

    public void setLoveTime(String loveTime) {
        this.loveTime = loveTime;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "teaName='" + teaName + '\'' +
                ", teaPrice='" + teaPrice + '\'' +
                ", teaAddPrice=" + teaAddPrice +
                ", type='" + type + '\'' +
                ", sellCount=" + sellCount +
                '}';
    }
}
