package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Comment;
import com.example.socialnetwork.service.CommentService;
import com.example.socialnetwork.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class CommentServlet extends HttpServlet {
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

        Comment comment = new Comment();
        CommentService commentService = new CommentServiceImpl();

        comment.setCid(commentService.curComment_num());
        comment.setBid(Integer.valueOf(request.getParameter("bid")));
        comment.setCommenter(session.getAttribute("username").toString());
        comment.setContent(request.getParameter("comment"));
        comment.setTime(new Timestamp(System.currentTimeMillis()));

        String href = request.getParameter("href");

        boolean flag = commentService.PostComment(comment);
        PrintWriter out = response.getWriter();
        if (flag){
            out.println("<script>");
//            out.println("alert('评论成功');");
            out.println("window.location.href='"+href+"';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('评论失败');");
            out.println("window.location.href='"+href+"';");
            out.println("</script>");
        }
    }
}