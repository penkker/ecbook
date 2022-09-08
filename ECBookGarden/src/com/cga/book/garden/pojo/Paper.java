package com.cga.book.garden.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Paper {

    private Integer id;
    private String paperName;
    private Integer likeStatus;
    private Date journalTime;
    private String content;

    private User userId; //n:1

    public Paper() {
    }

    public Paper(Integer id) {
        this.id = id;
    }

    public Paper(Integer id, String paperName, Integer likeStatus, Date journalTime,String content) {
        this.id = id;
        this.paperName = paperName;
        this.likeStatus = likeStatus;
        this.journalTime = journalTime;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(Integer likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Date getJournalTime() {
        return journalTime;
    }

    public void setJournalTime(Date journalTime) {
        this.journalTime = journalTime;
    }

    public User getUser() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User userId) {
        this.userId = userId;
    }

}
