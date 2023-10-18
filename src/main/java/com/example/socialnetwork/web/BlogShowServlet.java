package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/blogShowServlet")
public class BlogShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        BlogService blogService = new BlogServiceImpl();
        String username = request.getParameter("username");
        List<Blog> allblog = blogService.showAllBlog(username);
        mapper.writeValue(response.getOutputStream(), allblog);
    }
}
