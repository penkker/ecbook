package com.cga.book.garden.pojo;

public class HostReply {
    private Integer id;
    private String content;
    private String hostReplyDate;
    private User userId;
    private Reply replyId;

    public HostReply() {
    }

    public HostReply(Integer id) {
        this.id = id;
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

    public String getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(String hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Reply getReplyId() {
        return replyId;
    }

    public void setReplyId(Reply replyId) {
        this.replyId = replyId;
    }
}
