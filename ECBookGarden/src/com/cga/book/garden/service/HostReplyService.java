package com.cga.book.garden.service;

import com.cga.book.garden.pojo.HostReply;

import java.util.List;

public interface HostReplyService {

    //插入一条hostReply
    void setHostReply(Integer id, String hostReply, String replyDate, Integer replyId);

    //根据回复id查询主人回复信息
    List<HostReply> getHostReplyListByReplyId(Integer replyId);
}
