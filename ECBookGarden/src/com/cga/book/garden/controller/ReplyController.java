package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.HostReply;
import com.cga.book.garden.pojo.Reply;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.HostReplyService;
import com.cga.book.garden.service.ReplyService;
import com.cga.book.garden.service.UserService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReplyController {

    private ReplyService replyService;
    private UserService userService;
    private HostReplyService hostReplyService;

    //设置一条回复信息
    public String setReply(String remark, HttpSession session){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String replyDate = sdf.format(new Date());

        User currUser = (User)session.getAttribute("currUser");

        replyService.setReply(currUser.getId(),remark,replyDate,0);
        List<Reply> replyList = replyService.getReplyListBydsId(0);
        for (Reply reply : replyList){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);
            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
        }

        session.setAttribute("replyListTea",replyList);

        return "redirect:page.do?operate=page&page=bookdetail/product";

    }

    //书友论坛
    public String setReplyDiscussion(String remark,HttpSession session){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String replyDate = sdf.format(new Date());

        User currUser = (User)session.getAttribute("currUser");

        replyService.setReplyByDiscussion(currUser.getId(),remark,replyDate,1);
        List<Reply> replyList = replyService.getReplyListBydsId(1);
        for (Reply reply : replyList){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);
            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
        }

        session.setAttribute("replyListdsId",replyList);

        return "review/review";
    }

    //书友论坛
    public String forum(HttpSession session){

        int k = 1;
        List<Reply> replyListds = replyService.getReplyListBydsId(1);
        for (Reply reply : replyListds){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);

            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
            reply.setTemp(k++);

            List<HostReply> hostReplyListByReplyId = hostReplyService.getHostReplyListByReplyId(reply.getId());
            if (hostReplyListByReplyId != null) {
                for (HostReply hostReply1 : hostReplyListByReplyId) {
                    Integer hrId = hostReply1.getUserId().getId();
                    User user = userService.getUserById(hrId);
                    Reply reply1 = replyService.getReplyById(hostReply1.getReplyId().getId());
                    hostReply1.setUserId(user);
                    hostReply1.setReplyId(reply);

                }
                reply.setHostReplyList(hostReplyListByReplyId);
            }
        }

        session.setAttribute("replyListdsId",replyListds);

        return "comments/comments";
    }

    public String getForum(String hostReply,Integer replyId,HttpSession session){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String replyDate = sdf.format(new Date());

        User currUser = (User)session.getAttribute("currUser");

        hostReplyService.setHostReply(currUser.getId(),hostReply,replyDate,replyId);
        List<Reply> replyList = replyService.getReplyListBydsId(1);

        int k = 1;
        for (Reply reply : replyList){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);
            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
            reply.setTemp(k++);

            List<HostReply> hostReplyListByReplyId = hostReplyService.getHostReplyListByReplyId(reply.getId());
            if (hostReplyListByReplyId != null) {
                for (HostReply hostReply1 : hostReplyListByReplyId) {
                    Integer hrId = hostReply1.getUserId().getId();
                    User user = userService.getUserById(hrId);
                    Reply reply1 = replyService.getReplyById(hostReply1.getReplyId().getId());
                    hostReply1.setUserId(user);
                    hostReply1.setReplyId(reply);

                }
                reply.setHostReplyList(hostReplyListByReplyId);
            }
        }

        session.setAttribute("replyListdsId",replyList);

        return "comments/comments";
    }



    //设置一条回复信息
    public String setReplyBook(String remark, HttpSession session){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String replyDate = sdf.format(new Date());

        User currUser = (User)session.getAttribute("currUser");

        replyService.setReply(currUser.getId(),remark,replyDate,2);
        List<Reply> replyList = replyService.getReplyListBydsId(2);
        for (Reply reply : replyList){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);
            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
        }

        session.setAttribute("replyListBook",replyList);

        return "redirect:page.do?operate=page&page=bookdetail/product_book";

    }

}