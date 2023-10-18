package com.example.socialnetwork.web;

import com.example.socialnetwork.domain.Comment;
import com.example.socialnetwork.service.CommentService;
import com.example.socialnetwork.service.impl.CommentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class CommentShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");

        CommentService commentService = new CommentServiceImpl();
        Integer bid = Integer.valueOf(request.getParameter("bid"));
        List<Comment> comments = commentService.showAllComment(bid);
        mapper.writeValue(response.getOutputStream(),comments);
    }
}
