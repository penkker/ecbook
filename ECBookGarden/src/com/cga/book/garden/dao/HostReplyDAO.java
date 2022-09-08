package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.HostReply;

import java.util.List;

public interface HostReplyDAO {
    //插入一条hostReply信息
    void setHostReply(Integer id, String hostReply, String replyDate, Integer replyId);

    //根据replyId查询主人回复
    List<HostReply> getHostReplyListByReplyId(Integer replyId);
}
