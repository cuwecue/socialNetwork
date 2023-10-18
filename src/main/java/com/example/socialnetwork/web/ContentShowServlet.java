package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Blog;
import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/blogShowServlet")
public class ContentShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        BlogService blogService = new BlogServiceImpl();
        Integer bid = Integer.valueOf(request.getParameter("bid"));
        Blog ablog = blogService.showABlog(bid);
        System.out.println(ablog.getTitle());
        mapper.writeValue(response.getOutputStream(), ablog);
    }
}