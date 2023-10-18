package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.ReplytoCom;
import com.example.socialnetwork.service.ReplytoComService;
import com.example.socialnetwork.service.impl.ReplytoComServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class ReplytoComServlet extends HttpServlet {
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

        ReplytoComService replytoComService = new ReplytoComServiceImpl();
        ReplytoCom replytoCom = new ReplytoCom();
        replytoCom.setRid(replytoComService.curReplytoCom_num());
        replytoCom.setCid(Integer.valueOf(request.getParameter("cid")));
        replytoCom.setReplier(session.getAttribute("username").toString());
        replytoCom.setContent(request.getParameter("content"));
        replytoCom.setTime(new Timestamp(System.currentTimeMillis()));

        String href = request.getParameter("href");

        boolean flag = replytoComService.PostReplytoCom(replytoCom);
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
