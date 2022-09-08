package com.cga.book.garden.pojo;

import java.util.List;

public class Reply {
    private Integer id;
    private String content;
    private String replyDate;
    private User userId;
    private Integer dsId;
    private String headImg;
    private int temp;

    private List<HostReply> hostReplyList;


    public Reply() {
    }

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply(Integer id, String content, String replyDate) {
        this.id = id;
        this.content = content;
        this.replyDate = replyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getDsId() {
        return dsId;
    }

    public void setDsId(Integer dsId) {
        this.dsId = dsId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public List<HostReply> getHostReplyList() {
        return hostReplyList;
    }

    public void setHostReplyList(List<HostReply> hostReplyList) {
        this.hostReplyList = hostReplyList;
    }
}
