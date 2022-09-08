package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.ReplyDAO;
import com.cga.book.garden.pojo.Reply;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {

    @Override
    public void setReply(Integer userId, String remark,String replyDate,Integer dsid) {
        super.executeUpdate("insert into e_reply values(?,?,?,?,?)",0,remark,replyDate,userId,dsid);
    }


    @Override
    public List<Reply> getReplyList() {
        return super.executeQuery("select * from e_reply");
    }

    @Override
    public void setReplyByDiscussion(Integer userId, String remark, String replyDate, Integer dsid) {
        super.executeUpdate("insert into e_reply values(?,?,?,?,?)",0,remark,replyDate,userId,dsid);
    }

    @Override
    public List<Reply> getReplyListBydsId(Integer dsId) {
        return super.executeQuery("select * from e_reply where dsId = ?",dsId);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return super.load("select * from e_reply where id = ?",id);
    }
}
