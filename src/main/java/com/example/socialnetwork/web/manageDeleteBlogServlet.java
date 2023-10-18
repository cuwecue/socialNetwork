package com.example.socialnetwork.web;

import com.example.socialnetwork.service.BlogService;
import com.example.socialnetwork.service.impl.BlogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "manageDeleteBlogServlet", value = "/manageDeleteBlogServlet")
public class manageDeleteBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        BlogService blogService=new BlogServiceImpl();
        int bid=Integer.parseInt(request.getParameter("bid"));
        boolean flag=blogService.DeleteBlogs(bid);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),flag);
    }
}
