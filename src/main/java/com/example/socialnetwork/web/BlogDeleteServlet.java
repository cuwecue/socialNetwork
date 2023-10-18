package com.example.socialnetwork.web;

import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/blogDeleteServlet")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        BlogService blogService = new BlogServiceImpl();
        boolean flag = blogService.Delete(Integer.valueOf(request.getParameter("del_bid")));
        PrintWriter out = response.getWriter();
        if (flag){
            out.println("<script>");
            out.println("alert('删除成功');");
            out.println("window.location.href='blog_list.jsp';");
            out.println("</script>");
        } else {
            out.println("<script>");
            out.println("alert('添加失败');");
            out.println("window.location.href='blog_list.jsp';");
            out.println("</script>");
        }
    }
}
