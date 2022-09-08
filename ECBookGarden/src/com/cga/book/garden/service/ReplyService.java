package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Reply;

import java.util.List;

public interface ReplyService {

    //设置一条回复信息
    void setReply(Integer userId, String remark,String replyDate,Integer dsid);

    //查润所有回复信息
    List<Reply> getReplyList();

    void setReplyByDiscussion(Integer userId, String remark, String replyDate,Integer dsid);

    List<Reply> getReplyListBydsId(Integer dsId);

    //根据replyId查询回复信息
    Reply getReplyById(Integer id);
}
