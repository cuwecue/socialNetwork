package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.ReplytoRep;
import com.example.socialnetwork.service.ReplytoRepService;
import com.example.socialnetwork.service.impl.ReplytoRepServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class ReplytoRepServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        HttpSession session = request.getSession();

        ReplytoRepService replytoRepService = new ReplytoRepServiceImpl();
        ReplytoRep replytoRep = new ReplytoRep();
        replytoRep.setRid(replytoRepService.curReplytoRep_num());
        replytoRep.setTarget_rid(Integer.valueOf(request.getParameter("rid")));
        replytoRep.setReplier(session.getAttribute("username").toString());
        replytoRep.setContent(request.getParameter("content"));
        replytoRep.setTime(new Timestamp(System.currentTimeMillis()));

        String href = request.getParameter("href");


        boolean flag = replytoRepService.PostReplytoRep(replytoRep);
        PrintWriter out = response.getWriter();
        if (flag){
            out.println("<script>");
            out.println("alert('回复成功');");
            out.println("window.location.href='"+href+"';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('回复失败');");
            out.println("window.location.href='"+href+"';");
            out.println("</script>");
        }
    }
}
